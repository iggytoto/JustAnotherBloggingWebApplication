package leblogger.controllers.rest;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Iggytoto on 12.07.2017.
 */
@Controller
@RequestMapping(value = "/testController")
public class TestController {
    @Autowired
    Logger logger;

    @RequestMapping(method = RequestMethod.GET, value = "/testMethod")
    public String test(){
        logger.log(Priority.INFO,"Test log");
        return "test";
    }
}
