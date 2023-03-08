package bg.softuni.errors.web;

import bg.softuni.errors.model.ObjectNotFoundException;
import bg.softuni.errors.model.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ObjectNotFoundAdvice {

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(ObjectNotFoundException.class)
  public ModelAndView onProductNotFound(ObjectNotFoundException onfe) {
    ModelAndView modelAndView = new ModelAndView("object-not-found");

    modelAndView.addObject("objectId", onfe.getObjectId());
    modelAndView.addObject("objectType", onfe.getObjectType());

    return modelAndView;
  }

}
