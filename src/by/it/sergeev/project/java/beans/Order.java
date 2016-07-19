package by.it.sergeev.project.java.beans;

public class Order {
    private int ID;
    private int FK_Users;
    private int FK_Ad;
    private double Price;

    public int getFK_Ad() {
        return FK_Ad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFK_Users() {
        return FK_Users;
    }

    public void setFK_Users(int FK_Users) {
        this.FK_Users = FK_Users;
    }


    public void setFK_Ad(int FK_Ad) {
        this.FK_Ad = FK_Ad;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public Order() {
    }
    public Order(int ID, int FK_Users, int FK_Ad, double price, int FK_Ads) {
        this.ID = ID;
        this.FK_Users = FK_Users;
        this.FK_Ad = FK_Ad;
        Price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (ID != order.ID) return false;
        if (FK_Users != order.FK_Users) return false;
        if (FK_Ad != order.FK_Ad) return false;
        if (Double.compare(order.Price, Price) != 0) return false;

        return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ID;
        result = 31 * result + FK_Users;
        result = 31 * result + FK_Ad;
        temp = Double.doubleToLongBits(Price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", FK_Users=" + FK_Users +
                ", FK_Ad=" + FK_Ad +
                ", Price=" + Price +
                '}';
    }
}
