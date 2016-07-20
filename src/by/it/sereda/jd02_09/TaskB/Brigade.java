package by.it.sereda.jd02_09.TaskB;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "brigade", propOrder = {
        "pilot",
        "navigator",
        "stewardess"
})

public class Brigade {
    @XmlElement(required = true)
    private String pilot;
    @XmlElement(required = true)
    private String navigator;
    @XmlElement(name = "Stewardess", required = true)
    private String stewardess;

    public Brigade() {
    }

    public Brigade(String pilot, String navigator, String stewardess) {
        this.pilot = pilot;
        this.navigator = navigator;
        this.stewardess = stewardess;
    }

    public String getPilot() {
        return pilot;
    }

    public String getNavigator() {
        return navigator;
    }

    public String getStewardess() {
        return stewardess;
    }


    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public void setNavigator(String navigator) {
        this.navigator = navigator;
    }

    public void setStewardess(String stewardess) {
        this.stewardess = stewardess;
    }

    //преобразование в строку
    @Override
    public String toString() {
        return "\n" + "Brigade: pilot " + pilot + " navigator " + navigator + " stewardess " + stewardess;
    }
}
