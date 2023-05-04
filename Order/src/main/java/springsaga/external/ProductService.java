package springsaga.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springsaga.domain.*;

@FeignClient(name = "Product", url = "${api.url.Product}")
public interface ProductService {
    @RequestMapping(
        method = RequestMethod.PUT,
        path = "/products/{id}/decreasestock"
    )
    public void decreaseStock(
        @PathVariable("id") Long id,
        @RequestBody DecreaseStockCommand decreaseStockCommand
    );
}
