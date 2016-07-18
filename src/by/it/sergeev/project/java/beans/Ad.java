package by.it.sergeev.project.java.beans;

public class Ad {

    private int ID;
    private String Electronics;
    private String Manufacturer;
    private String Name;
    private String Model;
    private double Price;
    private String Description;
    private int FK_Users;

    public Ad() {

    }

    public Ad(int ID, String electronics, String manufacturer, String name, String model, double price, String description, int FK_Users) {
        this.ID = ID;
        this.Electronics = electronics;
        this.Manufacturer = manufacturer;
        this.Name = name;
        this.Model = model;
        this.Price = price;
        this.Description = description;
        this.FK_Users = FK_Users;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getElectronics() {
        return Electronics;
    }

    public void setElectronics(String electronics) {
        Electronics = electronics;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getFK_Users() {
        return FK_Users;
    }

    public void setFK_Users(int FK_Users) {
        this.FK_Users = FK_Users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (ID != ad.ID) return false;
        if (Double.compare(ad.Price, Price) != 0) return false;
        if (FK_Users != ad.FK_Users) return false;
        if (Electronics != null ? !Electronics.equals(ad.Electronics) : ad.Electronics != null) return false;
        if (Manufacturer != null ? !Manufacturer.equals(ad.Manufacturer) : ad.Manufacturer != null) return false;
        if (Name != null ? !Name.equals(ad.Name) : ad.Name != null) return false;
        if (Model != null ? !Model.equals(ad.Model) : ad.Model != null) return false;
        return Description != null ? Description.equals(ad.Description) : ad.Description == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        long temp;
        result = 31 * result + (Electronics != null ? Electronics.hashCode() : 0);
        result = 31 * result + (Manufacturer != null ? Manufacturer.hashCode() : 0);
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (Model != null ? Model.hashCode() : 0);
        temp = Double.doubleToLongBits(Price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (Description != null ? Description.hashCode() : 0);
        result = 31 * result + FK_Users;
        return result;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "ID=" + ID +
                ", Electronics='" + Electronics + '\'' +
                ", Manufacturer='" + Manufacturer + '\'' +
                ", Name='" + Name + '\'' +
                ", Model='" + Model + '\'' +
                ", Price=" + Price +
                ", Description='" + Description + '\'' +
                ", FK_Users=" + FK_Users +
                '}';
    }
}
