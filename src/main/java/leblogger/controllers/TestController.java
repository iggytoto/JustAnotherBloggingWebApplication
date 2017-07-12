package leblogger.controllers;

import leblogger.dal.IRepository;
import leblogger.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Controller
public class TestController {

    @Autowired
    IRepository<Post> postIRepository;

    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }

}
