package bg.softuni.events.model;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

  private List<Long> allProductIDs = new ArrayList<>();


  public OrderDTO setAllProductIDs(List<Long> allProductIDs) {
    this.allProductIDs = allProductIDs;
    return this;
  }

  public List<Long> getAllProductIDs() {
    return allProductIDs;
  }

  public OrderDTO addProductId(Long productId) {
    this.allProductIDs.add(productId);
    return this;
  }

}
