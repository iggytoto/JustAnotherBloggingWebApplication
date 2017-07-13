package leblogger.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Configuration
@PropertySource(value = {
        "classpath:application.properties",
        "file:${catalina.home}/conf/bloggingapp/application.properties"
}, ignoreResourceNotFound = true)
public class AppConfig{

}