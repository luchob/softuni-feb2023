package bg.softuni.dbimages.web;

import bg.softuni.dbimages.model.FileUploadModel;
import bg.softuni.dbimages.service.FileService;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UploadController {

  private FileService fileService;

  public UploadController(FileService fileService) {
    this.fileService = fileService;
  }

  @GetMapping("/upload")
  public String upload() {
    return "upload";
  }

  @PostMapping("/upload")
  public String upload(FileUploadModel uploadModel) throws IOException {
    return "redirect:/show/"+fileService.saveFile(uploadModel.getImg());
  }
}
