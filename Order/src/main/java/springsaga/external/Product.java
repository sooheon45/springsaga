package springsaga.external;

import java.util.Date;
import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private Integer stock;
}
