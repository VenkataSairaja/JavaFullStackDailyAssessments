import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
@EnableJpaRepositories
@EnableTransactionManagement
public class ApplicationConfig {
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
               .driverClassName("com.mysql.cj.jdbc.Driver")
               .url("jdbc:mysql://localhost:3306/mydb")
               .username("root")
               .password("password")
               .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPackagesToScan("com.example.entity");
        factory.setJpaProperties(additionalProperties());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return properties;
    }
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private Integer salary;

    // Getters and setters
}

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findByDepartment(String department);
    List<Employee> findBySalaryGreaterThan(Integer salary);
    @Query("SELECT e FROM Employee e WHERE e.department =?1 AND e.salary >?2")
    List<Employee> findByDepartmentAndSalaryGreaterThan(String department, Integer salary);
}

public class Main {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationConfig.class);
        application.run(args);

        EmployeeRepository employeeRepository = application.getBean(EmployeeRepository.class);

        // Retrieve all employees
        List<Employee> employees = employeeRepository.findAll();
        System.out.println("All employees: " + employees);

        // Retrieve employees by name
        List<Employee> employeesByName = employeeRepository.findByName("John");
        System.out.println("Employees by name: " + employeesByName);

        // Retrieve employees by department
        List<Employee> employeesByDepartment = employeeRepository.findByDepartment("Sales");
        System.out.println("Employees by department: " + employeesByDepartment);

        // Retrieve employees by salary greater than
        List<Employee> employeesBySalaryGreaterThan = employeeRepository.findBySalaryGreaterThan(50000);
        System.out.println("Employees by salary greater than: " + employeesBySalaryGreaterThan);

        // Retrieve employees by department and salary greater than
        List<Employee> employeesByDepartmentAndSalaryGreaterThan = employeeRepository.findByDepartmentAndSalaryGreaterThan("Sales", 50000);
        System.out.println("Employees by department and salary greater than: " + employeesByDepartmentAndSalaryGreaterThan);
    }
}