import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
@EnableWebMvc
public class ApplicationConfig implements WebMvcConfigurer {
    @Bean
    public GreetingController greetingController() {
        return new GreetingController();
    }
}

class GreetingController {
    @GetMapping("/greeting")
    public String getGreeting() {
        return "Hello, World!";
    }
}

public class Main {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationConfig.class);
        application.run(args);
    }
}