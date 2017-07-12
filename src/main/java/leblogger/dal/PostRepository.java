package leblogger.dal;

import leblogger.model.Post;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Repository
@Transactional(readOnly = true)
public class PostRepository implements ICrudRepository<Post>, IDbRepository<Post> {

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
    public void update(Post obj) throws SQLException {
        Session s = getSession();
        s.update(obj);
        s.flush();
    }

    @Transactional(readOnly = false)
    public void delete(long id) throws SQLException {
        Session s = getSession();
        Post p = (Post) s.get(Post.class, id);
        s.delete(p);
        s.flush();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public long countEntities() {
        Session s = getSession();
        return (Long) s.createCriteria(Post.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    public List<Post> getRange(int from, int to) {
        if(from <=0 || to <= 0 || from >= to){
            throw new IllegalArgumentException("From and To parameters should not be negative,zero, equal and From should be less that To.");
        }

        Criteria c = getSession().createCriteria(Post.class);
        c.addOrder(Order.desc("id"));
        c.setFirstResult(from);
        c.setMaxResults(to - from);
        return c.list();
    }
}
