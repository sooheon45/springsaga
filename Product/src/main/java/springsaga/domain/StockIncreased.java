package springsaga.domain;

import java.util.*;
import lombok.*;
import springsaga.domain.*;
import springsaga.infra.AbstractEvent;

@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;
    private String name;
    private Integer stock;

    public StockIncreased(Product aggregate) {
        super(aggregate);
    }

    public StockIncreased() {
        super();
    }
}
