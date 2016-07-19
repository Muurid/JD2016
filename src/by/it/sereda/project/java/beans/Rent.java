package by.it.sereda.project.java.beans;

public class Rent {

    private int ID;
    private int RoomCount;
    private double Price;
    private double Rating;
    private int Floor;
    private int Guests;
    private String Address;
    private String City;
    private int FK_Users;

    public Rent() {
    }

    public Rent(int ID, int roomCount, double price, double rating, int floor, int guests, String address, String city, int FK_Users) {
        this.ID = ID;
        RoomCount = roomCount;
        Price = price;
        Rating = rating;
        Floor = floor;
        Guests = guests;
        Address = address;
        City = City;
        this.FK_Users = FK_Users;
    }


    public int getID() {

        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRoomCount() {
        return RoomCount;
    }

    public void setRoomCount(int roomCount) {
        RoomCount = roomCount;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public int getFloor() {
        return Floor;
    }

    public void setFloor(int floor) {
        Floor = floor;
    }

    public int getGuests() {
        return Guests;
    }

    public void setGuests(int guests) {
        Guests = guests;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getFK_Users() {
        return FK_Users;
    }

    public void setFK_Users(int FK_Users) {
        this.FK_Users = FK_Users;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "ID=" + ID +
                ", RoomCount=" + RoomCount +
                ", Price=" + Price +
                ", Rating=" + Rating +
                ", Floor=" + Floor +
                ", Guests=" + Guests +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", FK_Users=" + FK_Users +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rent rent = (Rent) o;

        if (ID != rent.ID) return false;
        if (RoomCount != rent.RoomCount) return false;
        if (Double.compare(rent.Price, Price) != 0) return false;
        if (Double.compare(rent.Rating, Rating) != 0) return false;
        if (Floor != rent.Floor) return false;
        if (Guests != rent.Guests) return false;
        if (FK_Users != rent.FK_Users) return false;
        if (Address != null ? !Address.equals(rent.Address) : rent.Address != null) return false;
        return City != null ? City.equals(rent.City) : rent.City == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ID;
        result = 31 * result + RoomCount;
        temp = Double.doubleToLongBits(Price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Floor;
        result = 31 * result + Guests;
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        result = 31 * result + (City != null ? City.hashCode() : 0);
        result = 31 * result + FK_Users;
        return result;
    }
}
