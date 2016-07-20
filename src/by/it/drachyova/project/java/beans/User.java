package by.it.drachyova.project.java.beans;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int fk_role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFk_role() {
        return fk_role;
    }

    public void setFk_role(int fk_role) {
        this.fk_role = fk_role;
    }

    public User() {
    }

    public User(int id, String login, String password, String email, int fk_role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_role = fk_role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (getFk_role() != user.getFk_role()) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getFk_role();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fk_role=" + fk_role +
                '}';
    }
}
