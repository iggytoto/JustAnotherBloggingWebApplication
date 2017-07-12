package leblogger.dal.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Iggytoto on 11.07.2017.
 */
public abstract class DomainObject {

    protected int id;

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false)
    public int getId() {
        return id;
    }
}
