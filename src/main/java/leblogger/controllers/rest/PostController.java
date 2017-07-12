package leblogger.controllers.rest;

import leblogger.model.Post;
import leblogger.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@RestController
@RequestMapping(value = "/blog")
public class PostController {

    BlogService blogService;

    ArrayList<Post> posts = null;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewPosts(ModelAndView mav){
        posts=blogService.getAllPosts();
        mav.addObject("posts", posts);
        mav.setViewName("test.jsp");
        for(Post post:posts){
            System.out.println(post.getName());
            System.out.println(post.getText());
        }
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addPost(@ModelAttribute Post post) {
        blogService.addPost(post);
    }
}
