package bg.softuni.dbimages.model;

public class FileDownloadModel {

  private final byte[] fileData;
  private final String contentType;

  private final String fileName;

  public FileDownloadModel(byte[] fileData, String contentType, String fileName) {
    this.fileData = fileData;
    this.contentType = contentType;
    this.fileName = fileName;
  }

  public byte[] getFileData() {
    return fileData;
  }

  public String getContentType() {
    return contentType;
  }

  public String getFileName() {
    return fileName;
  }
}
