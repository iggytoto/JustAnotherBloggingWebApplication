package leblogger.services;

import leblogger.dal.ICrudRepository;
import leblogger.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by evgeny.semenov on 11.07.2017.
 */
@Service
public class BlogServiceImpl implements BlogService{

    ICrudRepository rep;

    @Autowired
    public void setRep(ICrudRepository rep) {
        this.rep = rep;
    }

    public ArrayList<Post> getAllPosts() {
        return new ArrayList(rep.readAll());
    }

    public void addPost(Post post){
        rep.create(post);
    }
}
