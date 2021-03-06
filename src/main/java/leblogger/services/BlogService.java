package leblogger.services;

import leblogger.model.Post;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by evgeny.semenov on 11.07.2017.
 */
@Service
public interface BlogService {
    ArrayList<Post> getAllPosts();
    long addPost(Post post);
    long getCount();
    ArrayList<Post> getRange(int from,int to);
    void deletePost(long id);
    void updatePost(Post post);
}
