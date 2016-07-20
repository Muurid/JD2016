package by.it.sereda.jd02_09.TaskB;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Airport", propOrder = {
        "administrator",
        "flight",
        "dispatcher",
        "brigades"
})

public class Airport {

    @XmlElement(required = true)
    private String administrator;
    @XmlElement(required = true)
    private String flight;
    @XmlElement(required = true)
    private String dispatcher;
    @XmlElement(required = true)
    private Brigades brigades = new Brigades();

    //конструктор без параметров
    public Airport() {
    }

    public Airport(String administrator, String flight, String dispatcher, Brigades brigades) {
        this.administrator = administrator;
        this.flight = flight;
        this.dispatcher = dispatcher;
        this.brigades = brigades;
    }

    //геттеры
    public String getAdministrator() {
        return administrator;
    }

    public String getFlight() {
        return flight;
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public Brigades getBrigades() {
        return brigades;
    }

    //сеттеры
    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void setBrigades(Brigades brigades) {
        this.brigades = brigades;
    }

    //преобразование в строку
    @Override
    public String toString() {
        return "Airport's administrator: " + administrator + " Flight:" + " " + flight + "  Dispatcher: " + dispatcher + brigades;
    }

    //сравнение
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //хэшкод
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

