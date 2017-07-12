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
        try {
            //I know that is a really bad way to test the things...
            postIRepository.create(new Post("Alexey","TestText"));

            List<Post> posts =  postIRepository.readAll();

            Post singlePost = postIRepository.read(posts.get(0).getId());

            singlePost.setName("setted new post name");
            postIRepository.update(singlePost);

            Post updatedPost = postIRepository.read(singlePost.getId());

            for (Post p: posts){
                postIRepository.delete(p.getId());
            }

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
