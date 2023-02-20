package bg.softuni.books.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String isbn;

  @ManyToOne
  private AuthorEntity author;

  public Long getId() {
    return id;
  }

  public BookEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public BookEntity setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getIsbn() {
    return isbn;
  }

  public BookEntity setIsbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  public AuthorEntity getAuthor() {
    return author;
  }

  public BookEntity setAuthor(AuthorEntity author) {
    this.author = author;
    return this;
  }

  @Override
  public String toString() {
    return "BookEntity{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", isbn='" + isbn + '\'' +
        ", author=" + (author != null ? author.getName() : null) +
        '}';
  }
}
