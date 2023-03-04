package bg.softuni.books.web;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.service.BookService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BooksController {

  private final BookService bookService;

  public BooksController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/books")
  public String getAllBook(Model model) {

    model.addAttribute("books", bookService.getAllBooks());
    return "lib";
  }

}
