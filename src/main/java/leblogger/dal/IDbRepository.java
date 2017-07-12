package leblogger.dal;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Iggytoto on 12.07.2017.
 */
public interface IDbRepository<T> {

    /**
     * Counts how many entities in database.
     *
     * @return number of rows.
     */
    long countEntities();

    /**
     * gets the range of entities.
     *
     * @param from position
     * @param to   position
     * @return list of elements of T
     * @throws IllegalArgumentException in case something wrong with params
     * @throws SQLException             in case something bad happened with sql
     */
    List<T> getRange(int from, int to) throws IllegalArgumentException, SQLException;
}
