package springsaga.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import springsaga.ProductApplication;
import springsaga.domain.StockIncreased;

@Entity
@Table(name = "Product_table")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer stock;

    @PostPersist
    public void onPostPersist() {
        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();
    }

    public static ProductRepository repository() {
        ProductRepository productRepository = applicationContext()
            .getBean(ProductRepository.class);
        return productRepository;
    }

    public static ApplicationContext applicationContext() {
        return ProductApplication.applicationContext;
    }

    public void decreaseStock(DecreaseStockCommand decreaseStockCommand) {
        // implement the business logics here:

        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.setOrderId(decreaseStockCommand.getOrderId());
        /** Logic **/

        stockDecreased.publishAfterCommit();
    }
}
