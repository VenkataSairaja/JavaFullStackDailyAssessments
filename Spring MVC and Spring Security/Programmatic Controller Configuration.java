import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
public class WebConfig {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @RequestMapping(method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        // Return a list of employees
        model.addAttribute("employees", Arrays.asList(new Employee("John Doe", 30), new Employee("Jane Doe", 25)));
        return "employees";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getEmployee(@PathVariable int id, Model model) {
        // Return an employee by ID
        model.addAttribute("employee", new Employee("John Doe", 30));
        return "employee";
    }
}

public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
}

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        DispatcherServlet servlet = new DispatcherServlet(context);
        // Register the servlet with a servlet container (e.g., Tomcat)
    }
}