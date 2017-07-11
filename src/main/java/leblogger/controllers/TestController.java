package leblogger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Controller
@RequestMapping(value = "/testController")
public class TestController {

    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }
}
