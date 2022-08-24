package geektime.spring.hello.greeting;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(GTChapter9GreetingApplicationRunner.class)
public class GTChapter9GreetingAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(GTChapter9GreetingApplicationRunner.class)
    @ConditionalOnProperty(name = "greeting.enabled", havingValue = "true", matchIfMissing = true)
    public GTChapter9GreetingApplicationRunner greetingApplicationRunner() {
        return new GTChapter9GreetingApplicationRunner();
    }
}
