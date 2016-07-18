package by.it.sinkevich.project.java.dao;

import java.util.List;

/**
 * Interface for all types of our DAO classes
 *
 * @param <TYPE> class, that we need to save in DB
 * @author Sinkevich Denis
 */
interface InterfaceDAO<TYPE> {

    //READ чтение отдельной сущности
    TYPE read(int id);

    //CREATE,UPDATE,DELETE обновление сущности
    boolean create(TYPE entity);

    boolean update(TYPE entity);

    boolean delete(TYPE entity);

    //READ - чтение всех элементов по условию
    List<TYPE> readAll(String WhereAndOrder);
}
