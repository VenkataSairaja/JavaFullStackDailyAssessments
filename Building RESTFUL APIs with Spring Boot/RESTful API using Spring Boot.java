import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
@EnableWebMvc
public class ApplicationConfig implements WebMvcConfigurer {
    @Bean
    public ProductRepository productRepository() {
        return new InMemoryProductRepository();
    }

    @Bean
    public ProductController productController() {
        return new ProductController(productRepository());
    }
}

class Product {
    private Long id;
    private String name;
    private double price;

    // Getters and setters
}

interface ProductRepository {
    List<Product> getAllProducts();
    Product getProduct(Long id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);
}

class InMemoryProductRepository implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProduct(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product existingProduct = getProduct(product.getId());
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
        }
    }

    @Override
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}

@RestController
@RequestMapping("/api/products")
class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.getProduct(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productRepository.addProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productRepository.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteProduct(id);
    }
}

public class Main {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationConfig.class);
        application.run(args);
    }
}