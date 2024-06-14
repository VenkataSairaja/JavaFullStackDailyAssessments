import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    // Getters and setters
}

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Getters and setters
}

public interface AuthorRepository {
    List<Author> findAll();
    Author findById(Long id);
    void save(Author author);
    void delete(Long id);
}

public interface BookRepository {
    List<Book> findAll();
    Book findById(Long id);
    void save(Book book);
    void delete(Long id);
}

public class AuthorRepositoryImpl implements AuthorRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Author> findAll() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    @Override
    public Author findById(Long id) {
        return em.find(Author.class, id);
    }

    @Override
    public void save(Author author) {
        em.persist(author);
    }

    @Override
    public void delete(Long id) {
        Author author = findById(id);
        if (author != null) {
            em.remove(author);
        }
    }
}

public class BookRepositoryImpl implements BookRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Override
    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    public void save(Book book) {
        em.persist(book);
    }

    @Override
    public void delete(Long id) {
        Book book = findById(id);
        if (book != null) {
            em.remove(book);
        }
    }
}

@Configuration
@EnableJpaRepositories
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

    @Bean
    public AuthorRepository authorRepository(EntityManagerFactory emf) {
        return new AuthorRepositoryImpl(emf);
    }

    @Bean
    public BookRepository bookRepository(EntityManagerFactory emf) {
        return new BookRepositoryImpl(emf);
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return properties;
    }
}

public class Main {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationConfig.class);
        application.run(args);
    }
}