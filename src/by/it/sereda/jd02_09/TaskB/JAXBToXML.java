package by.it.sereda.jd02_09.TaskB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class JAXBToXML {

    public static void main(String[] args) {

        Brigade brigadePetrov = new Brigade("Petrov", "Newman", "Kent");
        Brigade brigadeSidorov = new Brigade("Sidorov", "Miller", "Johns");
        Brigade brigadeNikolaev = new Brigade("Nikolaev", "Piaget", "Dorcey");
        Brigade brigadeKozlov = new Brigade("Kozlov", "Shwarzes", "Dockman");
        ArrayList<Brigade> brigade = new ArrayList<>();
        brigade.add(brigadePetrov);
        brigade.add(brigadeSidorov);
        brigade.add(brigadeNikolaev);
        brigade.add(brigadeKozlov);
        Brigades brigades = new Brigades();
        brigades.setList(brigade);
        Airport airport = new Airport();
        airport.setAdministrator("Ivanov");
        airport.setFlight("Minsk-London");
        airport.setDispatcher("Sokolov");
        airport.setBrigades(brigades);

        try {

            JAXBContext context = JAXBContext.newInstance(Airport.class);
            Marshaller marshaller = context.createMarshaller();

            File file = new File("src/by/it/sereda/jd02_09/TaskB/airport.xml");

            marshaller.marshal(airport, new FileOutputStream(file));
            System.out.println("XML-файл создан");

            marshaller.marshal(airport, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }









    }
}
