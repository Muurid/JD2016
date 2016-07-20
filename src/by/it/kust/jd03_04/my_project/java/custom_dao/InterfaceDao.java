package by.it.kust.jd03_04.my_project.java.custom_dao;

import java.util.List;

/**
 * Created by Tanya Kust.
 */
public interface InterfaceDao<TYPE> {
    // READ чтение отдельной сущности
    TYPE read(int id);
    // CREATE, UPDATE, DELETE ОБНОВЛЕНИЕ СУЩНОСТИ
    boolean create(TYPE entity);
    boolean update(TYPE entity);
    boolean delete(TYPE entity);

    // READ чтение всех элементов
    List<TYPE> getAll(String where);
}
