package leblogger.controllers.rest;

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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewPosts(ModelAndView mav) {
        long count = blogService.getCount();
        int pagesDivider = Integer.parseInt(env.getRequiredProperty("pagesDivider"));
        posts = blogService.getRange(0,pagesDivider-1);
        mav.addObject("posts", posts);
        mav.addObject("pagesCount", count/pagesDivider+(count%pagesDivider>0?1:0));
        mav.setViewName("home.jsp");
        return mav;
    }

    @RequestMapping(value="/{numberPageParam}", method = RequestMethod.GET)
    public ModelAndView viewNumberPage(ModelAndView mav,@PathVariable String numberPageParam) {
        int numberPage = Integer.parseInt(numberPageParam);
        long count = blogService.getCount();
        int pagesDivider = Integer.parseInt(env.getRequiredProperty("pagesDivider"));
        posts = blogService.getRange((numberPage-1)*pagesDivider, numberPage*pagesDivider-1);
        mav.addObject("posts", posts);
        mav.addObject("pagesCount", count/pagesDivider+(count%pagesDivider>0?1:0));
        mav.setViewName("home.jsp");
        return mav;
    }

    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public String addPost(@RequestParam(value = "name1", required = false) String name1,
                          @RequestParam(value = "text1", required = false) String text1) {
        blogService.addPost(new Post(name1, text1));
        return "redirect:/";
    }

    @RequestMapping(path = "/post/{id}" , method = RequestMethod.DELETE)
    public String deletePost(@PathVariable int id){
        blogService.deletePost(id);
        return "1";
    }

    @RequestMapping(path = "/post/{id}" , method = RequestMethod.PUT)
    public String updatePost(@PathVariable long id,
                          @RequestParam(value = "name1", required = false) String name1,
                          @RequestParam(value = "text1", required = false) String text1){
        blogService.updatePost(new Post(id,name1,text1));
        return "1";
    }

}
