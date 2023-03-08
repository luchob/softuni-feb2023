package bg.softuni.errors.web;

import bg.softuni.errors.model.ProductDTO;
import bg.softuni.errors.model.ProductNotFoundException;
import bg.softuni.errors.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {

  private ProductService productService;

  public ProductsController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products/{id}")
  public String getProductById(@PathVariable("id") Long id,
      Model model) {
    ProductDTO productDTO = productService.getProductByID(id);

    model.addAttribute("product", productDTO);

    return "product-detail";
  }

  @GetMapping("/products")
  public String getProducts() {
    throw new NullPointerException("OOOPS bug.");
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(ProductNotFoundException.class)
  public ModelAndView onProductNotFound(ProductNotFoundException pnfe) {
    ModelAndView modelAndView = new ModelAndView("product-not-found");

    modelAndView.addObject("productId", pnfe.getProductId());

    return modelAndView;
  }
}
