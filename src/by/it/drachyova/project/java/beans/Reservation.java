package by.it.drachyova.project.java.beans;

public class Reservation {
    private int id;
    private int fk_type;
    private int fk_user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_type() {
        return fk_type;
    }

    public void setFk_type(int fk_type) {
        this.fk_type = fk_type;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    public Reservation() {
    }

    public Reservation(int id, int fk_type, int fk_user) {
        this.id = id;
        this.fk_type = fk_type;
        this.fk_user = fk_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;

        Reservation that = (Reservation) o;

        if (getId() != that.getId()) return false;
        if (getFk_type() != that.getFk_type()) return false;
        if (getFk_user() != that.getFk_user()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getFk_type();
        result = 31 * result + getFk_user();
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", fk_type='" + fk_type + '\'' +
                ", fk_user='" + fk_user + '\'' +
                '}';
    }
}
