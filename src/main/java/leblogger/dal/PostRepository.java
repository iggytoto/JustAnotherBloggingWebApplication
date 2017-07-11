package leblogger.dal;

import leblogger.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Repository
public class PostRepository implements IRepository<Post> {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(Post obj) {
        saveOrUpdate(obj);
    }

    public Post read(int id) {
        Session s = getSession();
        return (Post) s.get(Post.class, id);
    }

    public List<Post> readAll() {
        Session s = getSession();
        return (List<Post>) s.createCriteria(Post.class).list();
    }

    public void update(Post obj) throws Exception {
        saveOrUpdate(obj);
    }

    public void delete(int id) throws Exception {
        Session s = getSession();
        Post p = (Post) s.get(Post.class, id);
        s.delete(p);
    }

    private void saveOrUpdate(Post obj) {
        Session s = getSession();
        s.saveOrUpdate(obj);
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
