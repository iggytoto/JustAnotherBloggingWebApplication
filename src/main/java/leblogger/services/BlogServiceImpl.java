package leblogger.services;

import leblogger.dal.ICrudRepository;
import leblogger.dal.IDbRepository;
import leblogger.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by evgeny.semenov on 11.07.2017.
 */
@Service
public class BlogServiceImpl implements BlogService {

    ICrudRepository crudRep;
    IDbRepository dbRep;

    @Autowired
    public void setRep(ICrudRepository rep) {
        this.crudRep = rep;
    }

    @Autowired
    public void setDbRep(IDbRepository dbRep) {
        this.dbRep = dbRep;
    }

    public ArrayList<Post> getAllPosts() {
        return new ArrayList(crudRep.readAll());
    }

    public void addPost(Post post) {
        crudRep.create(post);
    }

    public long getCount() {
        return dbRep.countEntities();
    }

    public ArrayList<Post> getRange(int from, int to){
        ArrayList posts = new ArrayList();
        try {
            posts.addAll(dbRep.getRange(from, to));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
    public void deletePost(long id){
        try {
            crudRep.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePost(Post post){
        try {
            crudRep.update(post);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
