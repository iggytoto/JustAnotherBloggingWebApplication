package leblogger.controllers.rest;

import leblogger.model.Post;
import leblogger.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@RestController
@RequestMapping(value = "/")
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
    public String addPost(@RequestParam(value = "name1", required = false) String name1,
                        @RequestParam(value = "text1", required = false) String text1) {

        blogService.addPost(new Post(name1,text1));

        return "redirect:/";

        //blogService.addPost(post);
    }
}
