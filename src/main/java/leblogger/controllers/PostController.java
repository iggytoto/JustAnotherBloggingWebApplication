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
@RequestMapping(value = "/post")
public class PostController extends BaseController {

    private BlogService blogService;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Long addPost(@RequestParam(value = "name1", required = false) String name1,
                        @RequestParam(value = "text1", required = false) String text1) {
        try {
            return blogService.addPost(new Post(name1, text1));
        } catch (Exception e) {
            return Long.valueOf(-1);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public Long deletePost(@PathVariable int id) {
        try {
            blogService.deletePost(id);
            return Long.valueOf(id);
        } catch (Exception e) {
            return Long.valueOf(-1);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public Long updatePost(@PathVariable long id,
                           @RequestParam(value = "name1") String name1,
                           @RequestParam(value = "text1") String text1) {
        try {
            blogService.updatePost(new Post(id, name1, text1));
            return id;
        } catch (Exception e) {
            return Long.valueOf(-1);
        }

    }

}
