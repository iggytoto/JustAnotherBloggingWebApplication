package leblogger.dal;

import leblogger.model.Post;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Repository
@Transactional(readOnly = true)
public class PostRepository implements IRepository<Post> {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private Logger logger;

    @Transactional(readOnly = false)
    public long create(Post obj) {
        Session s = getSession();
        long result = (Long) s.save(obj);
        s.flush();
        return result;
    }

    public Post read(long id) {
        Session s = getSession();
        return s.get(Post.class, id); // returning proxy object
    }

    public List<Post> readAll() {
        Session s = getSession();
        return (List<Post>) s.createCriteria(Post.class).addOrder(Order.desc("id")).list();
    }

    @Transactional(readOnly = false)
    public void update(Post obj) throws Exception {
        Session s = getSession();
        s.update(obj);
        s.flush();
    }

    @Transactional(readOnly = false)
    public void delete(long id) throws Exception {
        Session s = getSession();
        Post p = (Post) s.get(Post.class, id);
        s.delete(p);
        s.flush();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
