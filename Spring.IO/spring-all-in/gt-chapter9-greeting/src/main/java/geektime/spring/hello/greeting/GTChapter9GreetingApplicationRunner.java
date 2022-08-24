package geektime.spring.hello.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Slf4j
public class GTChapter9GreetingApplicationRunner implements ApplicationRunner {
    public GTChapter9GreetingApplicationRunner() {
        log.info("Initializing GTChapter9GreetingApplicationRunner.");
    }

    public void run(ApplicationArguments args) throws Exception {
        log.info("Hello everyone! We all like Spring! ");
    }
}
