package by.it.sereda.jd02_09.taskc;

import by.it.sereda.jd02_09.TaskB.Airport;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestWithJAXB {
    public static void main(String[] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Airport.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/sereda/jd02_09/taskc/Airport_XSD.xml");
            System.out.println("XML-файл прочитан:");
            Airport airport = (Airport) u.unmarshal(reader);
            System.out.println(airport);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
