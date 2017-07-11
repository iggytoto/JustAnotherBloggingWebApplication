package leblogger.controllers.rest;

import leblogger.dal.model.Post;
import leblogger.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@RestController
@RequestMapping(value = "/test")
public class PostController {

    //BlogService blogService;

    ArrayList<Post> posts = null;

/*    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView sayHello(ModelAndView mav){

        posts = new ArrayList<Post>();
        Post post0 = new Post("Евгений","Всем привет!");
        Post post1 = new Post("Алексей","Привет!");
        Post post2 = new Post("Сергей","Привет!");
        posts.add(post0);
        posts.add(post1);
        posts.add(post2);
        //posts=blogService.getAllPosts();

        mav.addObject("posts", posts);
        mav.setViewName("test");

        return mav;
    }

}
