package by.it.sereda.jd02_09.TaskB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JAXBFromXML {
    public static void main(String[] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Airport.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/sereda/JD02_09/TaskB/Airport.xml");
            System.out.println("XML-файл прочитан:");
            Airport hotel = (Airport) u.unmarshal(reader);
            System.out.println(hotel);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
