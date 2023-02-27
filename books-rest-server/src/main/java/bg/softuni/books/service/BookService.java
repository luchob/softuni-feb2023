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
  private AuthorRepository authorRepository;

  public BookService(BookRepository bookRepository,
      AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }


  public long createBook(BookDTO newBook) {
    String authorName = newBook.getAuthor().getName();
    Optional<AuthorEntity> authorOpt = this.authorRepository.findAuthorEntityByName(authorName);

    BookEntity newBookEntity = new BookEntity().
        setTitle(newBook.getTitle()).
        setIsbn(newBook.getIsbn()).
        setAuthor(authorOpt.orElseGet(() -> createNewAuthor(authorName)));

    return bookRepository.save(newBookEntity).getId();
  }

  private AuthorEntity createNewAuthor(String authorName) {
    return authorRepository.save(new AuthorEntity().setName(authorName));
  }

  public void deleteById(Long bookId) {
    bookRepository.
        findById(bookId).
        ifPresent(bookRepository::delete);
  }

  public Optional<BookDTO> findBookById(Long bookId) {
    return bookRepository.
        findById(bookId).
        map(this::map);
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
