package bg.softuni.events.service;


import bg.softuni.events.model.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class BonusPointService {

  private static final Logger LOGGER = LoggerFactory.getLogger(BonusPointService.class);

  @EventListener(OrderCreatedEvent.class)
  public void onOrderCreated(OrderCreatedEvent evt) {
    LOGGER.info("Bonus points added for products {} ", evt.getAllProductIDs());
  }

}
