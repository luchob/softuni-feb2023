package bg.softuni.events.service;

import bg.softuni.events.model.OrderCreatedEvent;
import bg.softuni.events.model.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
  private final ApplicationEventPublisher appEventPublisher;

  public OrderService(ApplicationEventPublisher appEventPublisher) {
    this.appEventPublisher = appEventPublisher;
  }

  public void createOrder(OrderDTO orderDTO) {

    LOGGER.info("Order was created");

    OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(this).
        setAllProductIDs(orderDTO.getAllProductIDs());

    appEventPublisher.publishEvent(orderCreatedEvent);
  }

}
