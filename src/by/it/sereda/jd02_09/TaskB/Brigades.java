package by.it.sereda.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "brigades", propOrder = {
        "brigade"
})

public class Brigades {

    @XmlElement(required = true)
    private ArrayList<Brigade> brigade = new ArrayList<Brigade>();

    public Brigades() {

    }

    public Brigades(ArrayList<Brigade> brigade) {
        this.brigade = brigade;
    }


    public void setList(ArrayList<Brigade> brigade) {
        this.brigade = brigade;
    }


    public ArrayList<Brigade> getList() {
        return brigade;
    }

    public boolean add(Brigade value) {
        return brigade.add(value);
    }

    @Override
    public String toString() {
        return String.valueOf(brigade);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}