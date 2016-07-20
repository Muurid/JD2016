package by.it.sereda.jd02_10.TaskAB;

import by.it.sereda.jd02_09.TaskB.Airport;
import by.it.sereda.jd02_09.TaskB.Brigade;
import by.it.sereda.jd02_09.TaskB.Brigades;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class TaskAB {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
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
        String json = gson.toJson(airport);
        System.out.print(json);
        Airport airportToPrint = gson.fromJson(json, Airport.class);
        System.out.println("\n\nAirport:");
        System.out.print(airportToPrint.toString());

    }
}
