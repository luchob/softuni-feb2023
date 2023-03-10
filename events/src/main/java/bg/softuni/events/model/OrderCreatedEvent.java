package bg.softuni.events.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationEvent;

public class OrderCreatedEvent extends ApplicationEvent {

  private List<Long> allProductIDs = new ArrayList<>();

  public OrderCreatedEvent(Object source) {
    super(source);
  }

  public OrderCreatedEvent setAllProductIDs(List<Long> allProductIDs) {
    this.allProductIDs = allProductIDs;
    return this;
  }

  public List<Long> getAllProductIDs() {
    return allProductIDs;
  }

  public OrderCreatedEvent addProductId(Long productId) {
    this.allProductIDs.add(productId);
    return this;
  }
}
