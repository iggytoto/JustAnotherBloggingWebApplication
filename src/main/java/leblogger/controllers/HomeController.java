package leblogger.controllers;

import leblogger.model.Post;
import leblogger.services.BlogService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Iggytoto on 14.07.2017.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController extends BaseController {

    private BlogService blogService;

    @Autowired
    private Logger logger;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewPosts() {
        logger.info("GET REQUEST FROM LOGGER");
        return new ModelAndView("redirect:/1");
    }

    @RequestMapping(value = "/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView viewNumberPage(ModelAndView mav, @PathVariable int pageNumber) {
        long count = blogService.getCount();
        int pagesDivider = Integer.parseInt(env.getRequiredProperty("pagesDivider"));
        List<Post> posts = blogService.getRange((pageNumber - 1) * pagesDivider, pageNumber * pagesDivider - 1);
        mav.addObject("posts", posts);
        mav.addObject("pagesCount", count / pagesDivider + (count % pagesDivider > 0 ? 1 : 0));
        mav.setViewName("home.jsp");
        return mav;
    }
}
