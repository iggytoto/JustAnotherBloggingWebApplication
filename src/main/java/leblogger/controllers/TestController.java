package leblogger.controllers;

import leblogger.dal.PostRepository;
import leblogger.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Controller
public class TestController {

    @Autowired
    PostRepository postIRepository;

    @RequestMapping(value = "/test")
    public String test(){
        try {
            postIRepository.create(new Post("Alexey","TestText"));
            System.out.println(postIRepository.readAll().size());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "test";
    }

    @RequestMapping(value = "/")
    public String home(){
        return "test";
    }

}
