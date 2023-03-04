package bg.softuni.books.service;

import bg.softuni.books.model.dto.AuthorDTO;
import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.AuthorEntity;
import bg.softuni.books.model.entity.BookEntity;
import bg.softuni.books.repository.AuthorRepository;
import bg.softuni.books.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
  public List<BookDTO> getAllBooks() {
    return bookRepository.findAll().
        stream().
        map(this::map).
        toList();
  }

  private BookDTO map(BookEntity bookEntity) {

    AuthorDTO authorDTO = new AuthorDTO().
        setName(bookEntity.getAuthor().getName());

    return new BookDTO().
        setId(bookEntity.getId()).
        setAuthor(authorDTO).
        setIsbn(bookEntity.getIsbn()).
        setTitle(bookEntity.getTitle());
  }
}
