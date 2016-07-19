package by.it.sereda.jd01_14;

import java.io.*;

public class TaskC {

    public static void printCatalog() {

        String startFromFolder = "/src/by/it/sereda/";
        String src = System.getProperty("user.dir") + startFromFolder;
        File rootFolder = new File(src);
        File[] rootCatalog = rootFolder.listFiles();

        System.out.println("Список каталогов начиная с каталога " + startFromFolder);
        for (File element : rootCatalog) {
            if (element.isDirectory()) {
                System.out.println(element.getName());
            }
        }

        System.out.println("Список файлов");
        for (File element : rootCatalog) {
            if (element.isFile()) {
                System.out.println(element.getName());
            }
        }
    }
}