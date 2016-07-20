package by.it.kust.jd03_04.my_project.java.custom_dao;

/**
 * Created by Tanya Kust.
 */
public class Dao {
    private static Dao dao;   // синглтон для Dao

    public UserDao user;   // Dao для пользователей
    public TourDao tour;   // Dao для туров
    public RoleDao role;   // Dao для ролей

    public static Dao getDao(){   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null){
            synchronized (Dao.class){
                if (dao == null){
                    dao = new Dao();
                    dao.user = new UserDao();
                    dao.tour = new TourDao();
                    dao.role = new RoleDao();
                }
            }
        }
        return dao;
    }
}
