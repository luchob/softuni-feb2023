package bg.softuni.events.service;

import bg.softuni.events.model.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

  private static final Logger LOGGER = LoggerFactory.getLogger(InventoryService.class);

  @EventListener(OrderCreatedEvent.class)
  public void onOrderCreated(OrderCreatedEvent evt) {
    LOGGER.info("Inventory subtracted for added for products {} ", evt.getAllProductIDs());
  }

}
