package bg.softuni.errors.model;

public class ObjectNotFoundException extends RuntimeException {
  private final long objectId;
  private final String objectType;

  public ObjectNotFoundException(long objectId, String objectType) {

    super("Object with ID " + objectId + " and type " + objectType + " not found!");

    this.objectId = objectId;
    this.objectType = objectType;
  }

  public long getObjectId() {
    return objectId;
  }

  public String getObjectType() {
    return objectType;
  }
}
