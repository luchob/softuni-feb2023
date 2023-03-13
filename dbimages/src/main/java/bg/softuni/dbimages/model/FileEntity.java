package bg.softuni.dbimages.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "files")
public class FileEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String fileName;

  private String contentType;

  @Lob
  @Column(length = Integer.MAX_VALUE)
  private byte[] data;

  public long getId() {
    return id;
  }

  public FileEntity setId(long id) {
    this.id = id;
    return this;
  }

  public String getFileName() {
    return fileName;
  }

  public FileEntity setFileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  public String getContentType() {
    return contentType;
  }

  public FileEntity setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  public byte[] getData() {
    return data;
  }

  public FileEntity setData(byte[] data) {
    this.data = data;
    return this;
  }
}
