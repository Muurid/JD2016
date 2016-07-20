package by.it.drachyova.project.java.custom_dao;

public class DAO {

    private static DAO dao; //синглтон для DAO

    public UserDAO user;    //DAO для пользователей
    public RoleDAO role;    //DAO для ролей
    public ReservationDAO reservation;        //DAO для заявок
    public RoomDAO room; // DAO для номеров

    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.reservation = new ReservationDAO();
                    dao.room = new RoomDAO();
                }
            }
        }
        return dao;
    }
}
