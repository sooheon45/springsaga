package springsaga.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class DecreaseStockCommand {

    private Integer stock;
    private String orderId;

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
}
