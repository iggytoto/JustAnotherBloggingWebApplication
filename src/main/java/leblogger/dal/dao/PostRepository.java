package leblogger.dal.dao;

import leblogger.dal.Hibernate.HibernateSessionFactory;
import leblogger.dal.interfaces.IRepository;
import leblogger.dal.model.Post;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Component
public class PostRepository implements IRepository<Post> {
    private static final String READALL_SQL = "from post";

    @Autowired
    private HibernateSessionFactory sessionFactory;

    public void create(Post obj) {
        saveOrUpdate(obj);
    }

    public Post read(int id) {
        Session s = getSession();
        s.beginTransaction();
        return (Post) s.load(Post.class, id);
    }

    public List<Post> readAll() {
        Session s =getSession();
        return (List<Post>) s.createCriteria(Post.class).list();
    }

    public void update(Post obj) throws Exception {
        saveOrUpdate(obj);
    }

    public void delete(int id) throws Exception {
        Session s = getSession();
        s.beginTransaction();
        Post p = (Post) s.load(Post.class, id);
        s.delete(p);
        s.flush();
    }

    private void saveOrUpdate(Post obj) {
        Session s = getSession();
        s.beginTransaction();
        s.saveOrUpdate(obj);
        s.flush();
    }

    private Session getSession(){
        return sessionFactory.getSessionFactory().openSession();
    }
}
