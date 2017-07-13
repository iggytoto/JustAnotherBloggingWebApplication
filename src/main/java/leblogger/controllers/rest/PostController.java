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
    public ModelAndView viewPosts(ModelAndView mav) {
        posts = blogService.getAllPosts();
        mav.addObject("posts", posts);
        mav.setViewName("home.jsp");

        return mav;
    }

    // добавить запись
    @RequestMapping(method = RequestMethod.POST)
    public String addPost(@RequestParam(value = "name1", required = false) String name1,
                          @RequestParam(value = "text1", required = false) String text1) {

        blogService.addPost(new Post(name1, text1));

        return "redirect:/";
    }

    // удалить запись
    @RequestMapping(path = "/post/{id}" , method = RequestMethod.DELETE)
//    public ModelAndView delPost(@PathVariable int id, ModelAndView mav){
//    @ResponseBody
    public String delPost(@PathVariable int id){
//        mav.addObject("test", id);
//        mav.setViewName("home");
        String res = "Удалён пост номер : " + id;

//        res = (id == 4)? "del ok" : "not ok";

//        return mav;
//        return "str : " + id;
        return res;
    }

    // изменить запись
    @RequestMapping(path = "/post/{id}" , method = RequestMethod.PUT)
    public String updPost(@PathVariable int id,
                          @RequestParam(value = "name1", required = false) String name1,
                          @RequestParam(value = "text1", required = false) String text1
                          ){

        String res = "Пост с номером : " + id + " и данными : " + name1 + ", " + text1 + "добавлен.";

        return res;
    }

}
