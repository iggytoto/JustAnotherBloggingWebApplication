package leblogger.dal.dao;

import leblogger.dal.Hibernate.HibernateSessionFactory;
import leblogger.dal.interfaces.IRepository;
import leblogger.dal.model.Post;
import org.hibernate.Session;
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
/*    private static final String READ_SQL = "from post where id=?";
    private static final String READALL_SQL = "from post";

    public void create(Post obj) {
        saveOrUpdate(obj);
    }

    public Post read(int id) {
        List query = getHibernateTemplate().find(READ_SQL, id);
        if (query.size() > 0) {
            return (Post) query.get(0);
        }
        return null;
    }

    public List<Post> readAll() {
        return (List<Post>) getHibernateTemplate().find(READALL_SQL);
    }

    public void update(Post obj) throws Exception {
        saveOrUpdate(obj);
    }

    public void delete(int id) throws Exception {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(obj);


        s.getTransaction().commit();
    }

    private void saveOrUpdate(Post obj) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        s.beginTransaction();
        s.saveOrUpdate(obj);
        s.getTransaction().commit();
    }*/
}
