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
    /**
     * Get all posts from database
     * @return
     */
    ArrayList<Post> getAllPosts();

    /**
     * Add new post in database
     * @param post
     */
    void addPost(Post post);

    /**
     * Get count of posts from database
     * @return
     */
    long getCount();

    /**
     * Get range of posts from database
     * @param from
     * @param to
     * @return
     */
    ArrayList<Post> getRange(int from,int to);

    /**
     * Delete post from database where id=
     * @param id
     */
    void deletePost(long id);

    /**
     * Update post in database
     * @param post
     */
    void updatePost(Post post);
}
