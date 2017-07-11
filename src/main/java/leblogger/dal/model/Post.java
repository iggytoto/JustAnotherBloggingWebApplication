package leblogger.dal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Entity
@Table(name= "post")
public class Post extends DomainObject  {

    private String name;
    private String text;

    public Post(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Column(name="name",nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "text",nullable = false)
    public String getText() {
        return text;
    }
}
