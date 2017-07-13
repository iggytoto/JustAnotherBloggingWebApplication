package leblogger.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Iggytoto on 13.07.2017.
 */
@Configuration
@PropertySource(value = {
        "classpath:log4j.properties",
        "file:${catalina.home}/conf/bloggingapp/log4j.properties"
}, ignoreResourceNotFound = true)
public class LoggerConfig {

    @Bean
    Logger getLogger() {
        return Logger.getLogger(AppConfig.class);
    }
}
