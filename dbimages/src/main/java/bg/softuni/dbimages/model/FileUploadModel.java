package bg.softuni.dbimages.model;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadModel {

  private MultipartFile img;

  public MultipartFile getImg() {
    return img;
  }

  public FileUploadModel setImg(MultipartFile img) {
    this.img = img;
    return this;
  }
}
