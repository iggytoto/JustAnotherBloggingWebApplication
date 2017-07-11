package leblogger.dal.interfaces;

/**
 * Created by Iggytoto on 11.07.2017.
 *
 * Simple generic Repository interface.
 */
public interface Repository<T> {
    /**
     * Creates the given T entity.
     * @param obj T entity to create in database.
     * @return positive ID of new entity if success, -1 in case of error.
     */
    int create(T obj);

    /**
     * Reads T entity by given id.
     * @param id given id.
     * @return T entity in case if it exist with current ID, null if not.
     */
    T read (int id);

    /**
     * Updates T entity in database with given id by the new one.
     * @param id id of entity to update.
     * @param obj object to update with.
     * @throws Exception in case something bad happened.
     */
    void update(int id,T obj) throws Exception;

    /**
     * Deletes the entity from database by given id.
     * @param id id of entity to delete.
     * @throws Exception in case something bad happened.
     */
    void delete(int id) throws Exception;
}
