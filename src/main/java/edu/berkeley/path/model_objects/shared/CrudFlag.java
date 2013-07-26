package edu.berkeley.path.model_objects.shared;

/**
 * Enumeration to hold CRUD Flag
 *
 * @author mnjuhn
 */
public enum CrudFlag {
  NONE("NONE"),
  CREATE("CREATE"),
  RETRIEVE("RETRIEVE"),
  UPDATE("UPDATE"),
  DELETE("DELETE");

  // String to hold enumeration string translation
  private final String enumName;

  /**
   * Private Constructor to set enumeration string as name
   *
   * @param name of string to associate enum value to
   */
  private CrudFlag(String name) {
    this.enumName = name;
  }

  /**
   * Checks if name matches enum value
   *
   * @param name of enum to check
   * @return true if name matches enum, otherwise false
   */
  public boolean equalsName(String name){
    // check if name is null, otherwise use string equals comparison
    if (name == null) {
      return false;
    } else {
      return this.enumName.equals(name);
    }
  }

  /**
   * Returns string name associated with enum
   *
   * @return string name associated with enum
   */
  public String toString(){
    return enumName;
  }
}

