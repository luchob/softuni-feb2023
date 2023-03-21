package bg.softuni.books.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookDTO {

  private Long id;
  private String title;
  @NotNull
  @Size(min = 5)
  private String isbn;

  private AuthorDTO author;

  public Long getId() {
    return id;
  }

  public BookDTO setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public BookDTO setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getIsbn() {
    return isbn;
  }

  public BookDTO setIsbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  public AuthorDTO getAuthor() {
    return author;
  }

  public BookDTO setAuthor(AuthorDTO author) {
    this.author = author;
    return this;
  }

  @Override
  public String toString() {
    return "BookDTO{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", isbn='" + isbn + '\'' +
        ", author=" + author +
        '}';
  }
}
