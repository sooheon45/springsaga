package springsaga.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springsaga.domain.*;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository
    extends PagingAndSortingRepository<Product, Long> {}
