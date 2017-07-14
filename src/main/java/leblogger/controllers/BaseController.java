package leblogger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * Created by Iggytoto on 14.07.2017.
 */
public abstract class BaseController {

    protected Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }
}
