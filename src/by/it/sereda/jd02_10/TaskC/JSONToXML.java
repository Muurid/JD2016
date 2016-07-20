package by.it.sereda.jd02_10.TaskC;

import by.it.sereda.jd02_09.TaskB.Airport;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;


public class JSONToXML {

    public static void main(String[] args) {
        File file;
        String src = System.getProperty("user.dir") + "/src/by/it/sereda/";
        file = new File(src + "jd02_10/TaskC/Airport.json");
        String txtData = "";
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                txtData = txtData.concat(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JAXBContext context = JAXBContext.newInstance(src + "jd02_10/TaskC/Airport.json");
            Marshaller marshaller = context.createMarshaller();
            File fileXML = new File("src/by/it/sereda/jd02_10/TaskC/Airport.xml");
            marshaller.marshal(context, new FileOutputStream(fileXML));
            System.out.println("XML-файл создан");
            marshaller.marshal(fileXML, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
