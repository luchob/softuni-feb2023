package bg.softuni.errors.web;

import bg.softuni.errors.model.ObjectNotFoundException;
import bg.softuni.errors.model.ProductNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

  @GetMapping("/categories/{id}")
  public String getCategoryById(@PathVariable("id") Long id) {
    throw new ObjectNotFoundException(id, "Category");
  }

}
