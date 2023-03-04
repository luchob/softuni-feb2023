package bg.softuni.books.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "authors")
public class AuthorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "author")
  private List<BookEntity> books;

  public Long getId() {
    return id;
  }

  public AuthorEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public AuthorEntity setName(String name) {
    this.name = name;
    return this;
  }

  public List<BookEntity> getBooks() {
    return books;
  }

  public AuthorEntity setBooks(List<BookEntity> books) {
    this.books = books;
    return this;
  }

  @Override
  public String toString() {
    return "AuthorEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", books=" + books +
        '}';
  }
}
