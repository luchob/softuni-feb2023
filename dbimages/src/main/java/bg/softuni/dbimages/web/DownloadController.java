package bg.softuni.dbimages.web;

import bg.softuni.dbimages.service.FileService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DownloadController {

  private FileService fileService;

  public DownloadController(FileService fileService) {
    this.fileService = fileService;
  }

  @GetMapping("/show/{fileId}")
  public String show(@PathVariable("fileId") long fileId, Model model) {

    model.addAttribute("fileId", fileId);
    return "show";
  }

  @GetMapping("/download/{fileId}")
  public HttpEntity<byte[]> download(@PathVariable("fileId") long fileId) {

    var fileDownloadModel = fileService.getFileById(fileId).orElseThrow();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(new MediaType(MimeTypeUtils.parseMimeType(fileDownloadModel.getContentType())));
    headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileDownloadModel.getFileName());
    headers.setContentLength(fileDownloadModel.getFileData().length);

    return new HttpEntity<>(fileDownloadModel.getFileData(), headers);
  }

}
