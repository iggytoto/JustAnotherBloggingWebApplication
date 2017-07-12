package leblogger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Controller
@RequestMapping(value = "/testController")
public class TestController {

    @RequestMapping(value = "/test123", method = RequestMethod.GET)
    public String test(){

        return "test";
    }

//    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
//    public String addPost(@ModelAttribute("userForm") Post post, ModelMap model){ // нужен объект в который я буду принимать пост

//        model.addAttribute("id", "1");
//        model.addAttribute("name", "NameName");
//        model.addAttribute("text", "TextText");

//        return "result";
//    }


}
