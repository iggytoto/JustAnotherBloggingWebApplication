package leblogger.dal.interfaces;

import java.util.List;

/**
 * Created by Iggytoto on 11.07.2017.
 *
 * Simple generic IRepository interface.
 */
public interface IRepository<T> {
/*    *//**
     * Creates the given T entity.
     * @param obj T entity to create in database.
     *//*
    void create(T obj);

    *//**
     * Reads T entity by given id.
     * @param id given id.
     * @return T entity in case if it exist with current ID, null if not.
     *//*
    T read (int id);

    *//**
     * Reads all T from database.
     * @return list of T.
     *//*
    List<T> readAll();

    *//**
     * Updates T entity in database with given id by the new one.
     * @param obj object to update with.
     * @throws Exception in case something bad happened.
     *//*
    void update(T obj) throws Exception;

    *//**
     * Deletes the entity from database by given id.
     * @param id id of entity to delete.
     * @throws Exception in case something bad happened.
     *//*
    void delete(int id) throws Exception;*/
}
