package bg.softuni.books.web;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.service.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/books")
public class BooksController {

  private final BookService bookService;

  public BooksController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public ResponseEntity<List<BookDTO>> getAllBook() {
    return ResponseEntity.
        ok(bookService.getAllBooks());
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long bookId) {
    Optional<BookDTO> theBook = bookService.findBookById(bookId);

    return
        theBook.
            map(ResponseEntity::ok).
            orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<BookDTO> deleteBookById(@PathVariable("id") Long bookId) {
   bookService.deleteById(bookId);

    return ResponseEntity.
        noContent().
        build();
  }

  @PostMapping()
  public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO newBook,
            UriComponentsBuilder uriComponentsBuilder) {
    long newBookId = bookService.createBook(newBook);

    return ResponseEntity.created(uriComponentsBuilder.
        path("/api/books/{id}").build(newBookId)).
        build();
  }

}
