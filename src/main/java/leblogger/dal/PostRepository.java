package leblogger.dal;

import leblogger.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Repository
@Transactional(readOnly = true)
public class PostRepository implements IPostRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void create(Post obj) {
        saveOrUpdate(obj);
    }

    public Post read(int id) {
        Session s = getSession();
        return s.get(Post.class, id);
    }

    public List<Post> readAll() {
        Session s = getSession();
        return (List<Post>) s.createCriteria(Post.class).list();
    }

    @Transactional(readOnly = false)
    public void update(Post obj) throws Exception {
        saveOrUpdate(obj);
    }

    @Transactional(readOnly = false)
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
