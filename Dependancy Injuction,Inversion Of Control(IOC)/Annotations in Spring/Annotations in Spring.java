//@Component Used to mark a class as a Spring component, which can be autodetected by the Spring container.
@Component
public class UserService {
    //...
}

//@Autowired Used to inject dependencies into a bean.
@Component
public class UserService {
    @Autowired
    private UserDAO userDAO;
    //...
}

//@Qualifier: Used to specify the name of the bean to be injected.
@Component
public class UserService {
    @Autowired
    @Qualifier("userDAOImpl")
    private UserDAO userDAO;
    //...
}

//@Scope: Used to specify the scope of a bean.
@Component
@Scope("prototype")
public class User {
    //...
}

//example of how to use annotations to configure a Spring bean:
@Configuration
public class AppConfig {
    @Bean
    @Scope("singleton")
    public DataSource dataSource() {
        return new DataSource();
    }
    
    @Bean
    public UserService userService() {
        UserService userService = new UserService();
        userService.setUserDAO(userDAO());
        return userService;
    }
    
    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }
}