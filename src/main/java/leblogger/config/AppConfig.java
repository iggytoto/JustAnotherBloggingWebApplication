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
public class AppConfig {

    @Bean
    Logger getLogger(){
        return Logger.getLogger(AppConfig.class);
    }

    //TODO make something adequate...
    public final static boolean IS_DEBUG = false;
}
