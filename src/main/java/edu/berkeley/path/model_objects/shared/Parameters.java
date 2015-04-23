package edu.berkeley.path.model_objects.shared;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


public class Parameters extends edu.berkeley.path.model_objects.jaxb.Parameters{

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
     * @return the projectId
     */
    @Override
    public Long getProjectId() {
        return super.getProjectId();
    }

    /**
     * @param projectId the projectId to set
     */

    @Override
    public void setProjectId(Long projectId) { super.setProjectId(projectId); }


  /**
   * Gets the value of the parameter config type id property.
   *
   * @return Long config type id
   *
   */
  @Override
  public Long getTypeId() {
    return super.getTypeId();
  }

  /**
   * Sets the value of the parameter config type id property.
   *
   * @param value to set id
   *
   */
  @Override
  public void setTypeId(Long value) {
    super.setTypeId(value);
  }

  /**
   * @return the description
   */
  @Override
  public String getDescription() {
    return super.getDescription();
  }

  /**
   * @param desc the description to set
   */
  @Override
  public void setDescription(String desc) {
    super.setDescription(desc);

  }

  /**
	 * Gets the value of the parameters property.
   *
	 * @return ArrayList<Parameter> the list of parameters
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Parameter> getParameters() {
		return (ArrayList<Parameter>)(ArrayList<?>) super.getParameter();
	}	
	
	
	/**
	 * Set the parameters list. Attaches list of Parameter Model Objects to scenario.
	 * 
	 * @param parameters	List of extended Parameters to add
	 */
	public void setParameters(List<Parameter> parameters) {
		 List<edu.berkeley.path.model_objects.jaxb.Parameter> pSet = (ArrayList<edu.berkeley.path.model_objects.jaxb.Parameter>)parameter;
		 if ( pSet == null ) 
			  pSet = new ArrayList<edu.berkeley.path.model_objects.jaxb.Parameter>();  
		
		pSet.clear();
		pSet.addAll(parameters);
		parameter = pSet;
	}
	
	/**
	 *  Add the parameter to the parameters list.
	 *  
	 * 
	 * @param p	Parameter to add
	 */
	public void setParameter(Parameter p) {
		getParameters().add(p);
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
   * Format: DD-MON-YYYY HH24:MM:SS
   *
   * @param  value
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
   * @param  flag enumeration
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

    /**
     * Override Jaxb getters for children to manage Json serialization
     */
    @Override
    @JsonIgnore
    public List<edu.berkeley.path.model_objects.jaxb.Parameter> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<edu.berkeley.path.model_objects.jaxb.Parameter>();
        }
        return this.parameter;
    }


}