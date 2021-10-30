package ec.prueba.cobiscorp.config;

import ec.prueba.cobiscorp.aop.logging.LoggingAspect;
import ec.prueba.cobiscorp.util.Constants;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

    @Bean
    @Profile(Constants.SPRING_PROFILE_DEVELOPMENT)
    public LoggingAspect loggingAspect(Environment env) {
        return new LoggingAspect(env);
    }
}
