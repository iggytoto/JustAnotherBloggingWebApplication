package leblogger.dal;

import java.util.List;

/**
 * Created by Iggytoto on 12.07.2017.
 */
public interface IDbRepository<T> {

    /**
     * Counts how many entities in database.
     * @return number of rows.
     */
    int countEntities();

    /**
     * gets the range of entities.
     * @param from position
     * @param to position
     * @return list of elements of T
     */
    List<T> getRange(int from,int to);
}
