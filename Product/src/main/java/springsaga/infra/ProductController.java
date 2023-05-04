package springsaga.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springsaga.domain.*;

@RestController
// @RequestMapping(value="/products")
@Transactional
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(
        value = "products/{id}/decreasestock",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Product decreaseStock(
        @PathVariable(value = "id") Long id,
        @RequestBody DecreaseStockCommand decreaseStockCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /product/decreaseStock  called #####");
        Optional<Product> optionalProduct = productRepository.findById(id);

        optionalProduct.orElseThrow(() -> new Exception("No Entity Found"));
        Product product = optionalProduct.get();
        product.decreaseStock(decreaseStockCommand);

        productRepository.save(product);
        return product;
    }
}
