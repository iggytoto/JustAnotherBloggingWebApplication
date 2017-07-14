package leblogger.controllers;

import leblogger.model.Post;
import leblogger.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@RestController
@RequestMapping(value = "/")
public class PostController {

    private Environment env;

    private BlogService blogService;

    private ArrayList<Post> posts = null;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    // добавить запись
    @RequestMapping(path = "/post/", method = RequestMethod.POST)
    public String addPost(@RequestParam(value = "name1", required = false) String name1,
                          @RequestParam(value = "text1", required = false) String text1) {

//        long res = blogService.addPost(new Post(name1, text1));
        return "123";
    }

    // удалить запись
    @RequestMapping(path = "/post/{id}", method = RequestMethod.DELETE)
    public String deletePost(@PathVariable int id) {

//        blogService.deletePost(id);

        return "postDeleted";
    }

    // изменить запись
    @RequestMapping(path = "/post/{id}", method = RequestMethod.PUT) // !
    public String updatePost(@PathVariable long id,
                             @RequestParam(value = "name1", required = false) String name1,
                             @RequestParam(value = "text1", required = false) String text1) {

//        blogService.updatePost(new Post(id, name1, text1));

        return "postChanged";
    }

}
