package leblogger.controllers;

import leblogger.dal.dao.PostRepository;
import leblogger.dal.interfaces.IRepository;
import leblogger.dal.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Controller
@RequestMapping(value = "/testController")
public class TestController {

/*
    @Autowired
    PostRepository postIRepository;

    @RequestMapping(value = "/test")
    public String test(){
        postIRepository.create(new Post("Alexey","TestText"));
        System.out.println(postIRepository.readAll().size());
        return "test";
    }
*/

}
