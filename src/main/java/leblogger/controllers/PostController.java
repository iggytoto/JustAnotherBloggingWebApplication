package leblogger.controllers;

import leblogger.model.Post;
import leblogger.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Iggytoto on 11.07.2017.
 */
@RestController
@RequestMapping(value = "/post")
public class PostController {

    private BlogService blogService;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    // добавить запись
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String addPost(@RequestParam(value = "name1", required = false) String name1,
                          @RequestParam(value = "text1", required = false) String text1) {

        long res = blogService.addPost(new Post(name1, text1));
        return String.valueOf(res);
    }

    // удалить запись
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String deletePost(@PathVariable int id) {
        blogService.deletePost(id);
        return String.valueOf(id);
    }

    // изменить запись
    @RequestMapping(path = "/{id}", method = RequestMethod.POST) // !
    public String updatePost(@PathVariable long id,
                             @RequestParam(value = "name1", required = false) String name1,
                             @RequestParam(value = "text1", required = false) String text1) {
        blogService.updatePost(new Post(id, name1, text1));
        return String.valueOf(id);
    }
}
