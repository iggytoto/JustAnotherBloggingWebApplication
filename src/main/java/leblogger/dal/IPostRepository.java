package leblogger.dal;

import leblogger.model.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Iggytoto on 11.07.2017.
 */
public interface IPostRepository {
    @Transactional(readOnly = false)
    void create(Post obj);

    Post read(int id);

    List<Post> readAll();

    @Transactional(readOnly = false)
    void update(Post obj) throws Exception;

    @Transactional(readOnly = false)
    void delete(int id) throws Exception;
}
