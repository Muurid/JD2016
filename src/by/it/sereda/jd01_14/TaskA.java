package by.it.sereda.jd01_14;

import java.io.*;


public class TaskA {

    static void generatorRandomFile() throws IOException {

        String src = System.getProperty("user.dir") + "/src/by/it/sereda/";
        String filename = src + "jd01_14/binary.dat";

        File file =new File(filename);
        FileOutputStream fos = null;

        try {
            fos=new FileOutputStream (file);
            for (int i = 0; i < 20; i++) {
                fos.write((int)(Math.random()*100));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка записи файла" + filename);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока записи" + e);
            }

        }


        try (DataInputStream inp = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(filename))
                )
        ) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                sum = sum + i;
                count++;
            }
            System.out.println("Average=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
