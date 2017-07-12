package leblogger.model;

import javax.persistence.*;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Entity
@Table(name = "post")
public class Post {

    private long id;
    private String name;
    private String text;

    public Post(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Post() {

    }

    public void setId(long id) {
        this.id = id;
    }


    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "text", nullable = false)
    public String getText() {
        return text;
    }
}
