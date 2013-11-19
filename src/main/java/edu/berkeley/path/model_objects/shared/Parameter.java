package edu.berkeley.path.model_objects.shared;

public class Parameter extends edu.berkeley.path.model_objects.jaxb.Parameter {

  /**
   * Gets the value of the id property.
   *
   * @return Long id
   *
   */
  @Override
  public Long getId() {
    return super.getId();
  }

  /**
   * Sets the value of the id property.
   *
   * @param value to set id
   *
   */
  @Override
  public void setId(Long value) {
    super.setId(value);
  }

  /**
   * Gets the value of the name property.
   *
   * @return String name
   *
   */
	@Override
  public String getName() {
      return super.getName();
  }

  /**
   * Sets the value of the name property.
   *
   * @param String name
   *
   */
	@Override
  public void setName(String value) {
      super.setName(value);
  }

  /**
   * Gets the value of the value property.
   *
   * @return String associated with name
   *
   */
	@Override
  public String getValue() {
      return super.getValue();
  }

  /**
   * Sets the value associated with name
   *
   * @param value
   *
   */
	@Override
  public void setValue(String value) {
      super.setValue(value);
  }
	
	
  /**
   * Gets the value of the modStamp property.
   *
   * @return String
   *
   */
	@Override
  public String getModStamp() {
      return super.getModStamp();
  }

  /**
   * Sets the value of the modStamp property.
   * Format: DD-MON-YYYY HH24:MI:SS.FF6
   *
   * @param String value
   *
   */
	@Override
  public void setModStamp(String value) {
      super.setModStamp(value);
  }

  /**
   * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
   *
   * @return CRUD Flag enumeration
   */
  public CrudFlag getCrudFlagEnum() {

    CrudFlag flag = null;
    // Check if CRUDFlag is null, if so return NONE enumeration
    if (super.getCrudFlag() == null) {
      setCrudFlagEnum(CrudFlag.NONE);
      flag = CrudFlag.NONE;
    }
    else {
      switch (CrudFlag.valueOf(super.getCrudFlag())) {
        case CREATE:
          flag = CrudFlag.CREATE;
          break;
        case RETRIEVE:
          flag = CrudFlag.RETRIEVE;
          break;
        case UPDATE:
          flag = CrudFlag.UPDATE;
          break;
        case DELETE:
          flag = CrudFlag.DELETE;
          break;
        default:
          flag = CrudFlag.NONE;
          break;

      }
    }
    return flag;
  }

  /**
   * Set CRUD (Create, Retrieve, Update, Delete) Action Flag for object
   *
   * @param CRUD Flag enumeration
   */
  public void setCrudFlagEnum(edu.berkeley.path.model_objects.shared.CrudFlag flag) {
    // Check if CRUDFlag is null, if so return NONE enumeration
    if (flag == null) {
      super.setCrudFlag("NONE");
    }
    else {
      switch (flag) {
        case CREATE:
          super.setCrudFlag("CREATE");
          break;
        case RETRIEVE:
          super.setCrudFlag("RETRIEVE");
          break;
        case UPDATE:
          super.setCrudFlag("UPDATE");
          break;
        case DELETE:
          super.setCrudFlag("DELETE");
          break;
        default:
          super.setCrudFlag("NONE");
          break;

      }
    }
  }
}
