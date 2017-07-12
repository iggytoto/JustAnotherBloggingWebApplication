package leblogger.services;

import leblogger.dal.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by evgeny.semenov on 11.07.2017.
 */
@Service
public interface BlogService {
    ArrayList<Post> getAllPosts();
    void addPost(Post post);
}
