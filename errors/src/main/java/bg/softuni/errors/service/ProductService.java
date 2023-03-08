package bg.softuni.errors.service;

import bg.softuni.errors.model.ProductDTO;
import bg.softuni.errors.model.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  public ProductDTO getProductByID(long productId) {
    throw new ProductNotFoundException(productId);
  }

}
