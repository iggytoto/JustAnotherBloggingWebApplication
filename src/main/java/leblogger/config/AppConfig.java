package leblogger.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Iggytoto on 11.07.2017.
 */
@Configuration
public class AppConfig {

    @Bean
    Logger getLogger(){
        return Logger.getLogger(AppConfig.class);
    }

}
