package bg.softuni.events.web;

import bg.softuni.events.model.OrderDTO;
import bg.softuni.events.service.OrderService;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

  private OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/orders/dummy/create")
  void createDummyOrder() {
    OrderDTO dummyOrderDTO = new OrderDTO();
    Random rand = new Random();
    for (int i = 0; i < 3; i++) {
      dummyOrderDTO.addProductId(rand.nextLong(100));
    }

    orderService.createOrder(dummyOrderDTO);
  }

}
