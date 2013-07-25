/**
 * Copyright (c) 2012, Regents of the University of California
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *   Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 **/

package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.MOException;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import java.util.ArrayList;

public class Splitratio extends edu.berkeley.path.model_objects.jaxb.Splitratio {

  // Array of ratioArray, idArray, modStampArray and crudFlagArray derived from comma separated content strings
  /** @y.exclude */ private ArrayList<Double> ratioArray;
  /** @y.exclude */ private ArrayList<Long> idArray;
  /** @y.exclude */ private ArrayList<String> modStampArray;
  /** @y.exclude */ private ArrayList<CrudFlag> crudFlagArray;
  /** @y.exclude */ private int ratioSize;

	/**
	 * @return the split ratio's link in
	 */
	@Override
	public long getLinkIn() {
		return super.getLinkIn();
	}
	
	/**
	 * @param linkIn set the split ratio's link in
	 */
	@Override
	public void setLinkIn(long linkIn) {
		super.setLinkIn(linkIn);
	}
	
	/**
	 * @return the split ratio's link out
	 */
	@Override
	public long getLinkOut() {
		return super.getLinkOut();
	}
	
	/**
	 * @param linkOut set the split ratio's link out
	 */
	@Override
	public void setLinkOut(long linkOut) {
		super.setLinkOut(linkOut);
	}

  /**
   * @param id the vehicle type id for this ratio
   */
  @Override
  public void setVehicleTypeId(long id) {
    super.setVehicleTypeId(id);
  }

  /**
   * @return the vehicle type id for this ratio
   */
  @Override
  public long getVehicleTypeId() {
    return super.getVehicleTypeId();
  }

  /**
   * Gets the length of the number of ratios for a particular link in,
   * link out and vehicle-type.  Essentially the number of dt's
   *
   * @return current number of ratios defined
   */
  public int getRatioSize() throws MOException {
    if (ratioArray == null) {
      setRatioArray();
    }

    return ratioArray.size();
  }

  /**
   * Gets the value of the ratio property.
   *
   * @param offset dt to get ratio from
   * @return ratio value
   *
   */
  public Double getRatio(int offset) throws MOException {

    Double ratio = null;
    // Ratio -- if no ratioArray list has been created, create one
    if (ratioArray == null) {
      setRatioArray();
    }
    try {
      // get ratio value at offset
      ratio = ratioArray.get(offset);
    } catch(Exception ex) {
      throw new MOException(ex,
          "Error getting split ratio value at offset " + offset + ".");
    }
    return ratio;
  }

  /**
   * Sets the value of the ratio property.
   *
   */
  private void setRatio(int offset, Double value) throws MOException {

    // Ratio -- if no ratioArray list has been created, create one
    if (ratioArray == null) {
      setRatioArray();
    }

    try {
      // add ratio to array at offset
      ratioArray.add(offset, value);
      // Create content string based on ratioArray list, by removing "[", "]" characters and
      // spaces between commas.
      String ratioContent = ratioArray.toString().replaceAll("(\\[|\\]|\\s)","");
      super.setContent(ratioContent);
    }
    catch(Exception ex) {
      throw new MOException(ex,
          "Error adding new split ratio value " + value + " at offset " + offset +
              ". Must add ratio's in order.");
    }
  }

  /**
   * Gets the value of the id property.
   *
   */
  private Long getId(int offset) throws MOException {

    Long id = null;

    // Id -- if no idArray list has been created, create one
    if (idArray == null) {
      setIdArray();
    }
    try {
      // get id value at offset
      id = idArray.get(offset);
    } catch(Exception ex) {
      throw new MOException(ex,
          "Error getting split ratio id at offset " + offset + ".");
    }
    return id;

  }

  /**
   * Sets the value of the id property.
   *
   */
  private void setId(int offset, Long value) throws MOException {

    // idArray -- if no idArray list has been created, create one
    if (idArray == null) {
      setIdArray();
    }
    try {
      // add ratio to array at offset
      idArray.add(offset, value);
      // Create content string based on ratioArray list, by removing "[", "]" characters and
      // spaces between commas.
      String idContent = idArray.toString().replaceAll("(\\[|\\]|\\s)","");
      super.setIds(idContent);
    }
    catch(Exception ex) {
      throw new MOException(ex,
          "Error adding new split ratio id " + value + " at offset " + offset +
              ". Must add ratio's in order.");
    }
  }

  /**
   * Gets the value of the modstamp property.
   *
   */
  private String getModStamp(int offset) throws MOException {

    String modStamp = null;

    // modStamp -- if no modStampArray list has been created, create one
    if (modStampArray == null) {
      setModStampArray();
    }
    try {
      // get modStamp value at offset
      modStamp = modStampArray.get(offset);
    } catch(Exception ex) {
      throw new MOException(ex,
          "Error getting split ratio modStamp at offset " + offset + ".");
    }
    return modStamp;
  }

  /**
   * Sets the value of the modStamp property.
   *
   */
  private void setModStamp(int offset, String value) throws MOException {

    // ModStamp -- if no modStampArray list has been created, add one
    if (modStampArray == null) {
      setModStampArray();
    }
    try {
      // add ratio to array at offset
      modStampArray.add(offset, value);
      // Create content string based on ratioArray list, by removing "[", "]" characters and
      // spaces between commas.
      String modStampContent = modStampArray.toString().replaceAll("(\\[|\\]|,\\s,)","");
      super.setModStamps(modStampContent);
    }
    catch(Exception ex) {
      throw new MOException(ex,
          "Error adding new split ratio modStamp " + value + " at offset " + offset +
              ". Must add ratio's in order.");
    }
  }

  /**
   * Gets the value of the CrudFlag property.
   *
   */
  private CrudFlag getCrudFlag(int offset) throws MOException {

    CrudFlag crudFlag = null;

    // CrudFlag -- if no crudFlagArray list has been created, add one
    if (crudFlagArray == null) {
      setCrudFlagArray();
    }
    try {
      // get crudFlag value at offset
      crudFlag = crudFlagArray.get(offset);
    } catch(Exception ex) {
      throw new MOException(ex,
          "Error getting crudFlag modStamp at offset " + offset + ".");
    }
    return crudFlag;

  }

  /**
   * Sets the value of the modStamp property.
   *
   */
  private void setCrudFlag(int offset, CrudFlag value) throws MOException {

    // CrudFlag -- if no crudFlagArray list has been created, add one
    if (crudFlagArray == null) {
      setCrudFlagArray();
    }
    try {
      // add CrudFlag to array at offset
      crudFlagArray.add(offset, value);
      // Create content string based on crudFlagArray list, by removing "[", "]" characters and
      // spaces between commas.
      String crudFlagContent = crudFlagArray.toString().replaceAll("(\\[|\\]|\\s)","");
      setContent(crudFlagContent);
    }
    catch(Exception ex) {
      throw new MOException(ex,
          "Error adding new split ratio CRUDFlag " + value.toString() + " at offset " + offset +
              ". Must add ratio's in order.");
    }
  }


  /**
   * Function to add split ratio to end of list by offset (dt) or update existing split
   * ratio. If a new split ratio for a dt is added it must be done in order.
   *
   * @param offset dt offset to add ratio
   * @param ratio new offset value
   * @param id of split ratio in database, can be null
   * @param modStamp of split ration in database, can be null
   * @param flag of database action (CRUD) on splitratio, can be null
   *
   * @throws MOException
   */
  public void setRatio(int offset, Double ratio, Long id, String modStamp, CrudFlag flag) throws MOException {

    setRatio(offset, ratio);
    if (id != null) {
      setId(offset, id);
    }
    if (modStamp != null) {
      setModStamp(offset, modStamp);
    }
    if (flag != null) {
      setCrudFlag(offset, flag);
    }
  }

	/**
	 * Creates the ratioArray arraylist object based on ratio content string
   * @throws MOException
   *
	 */
	private void setRatioArray() throws MOException {

    String ratioContent = super.getContent();
    // Create array representation of split ratios indexed by dt
    try {
      ratioArray = new ArrayList<Double>();
      // if ratio content value exists populate ratioArray arraylist from string
      if (ratioContent != null) {
        String[] contentArray = ratioContent.split(",");
        // For each value separated by a comma, add it to content array
        for (int i = 0; i < contentArray.length; i++) {
          ratioArray.add(Double.valueOf(contentArray[i].trim()));
        }
      }
    }
    catch (Exception ex) {
      throw new MOException(ex,
          "Invalid split ratio content string. Should be a comma separated string of double values.");
    }
	}

  /**
   * Set idArray arraylist based on id content string
   * @throws MOException
   *
   */
  private void setIdArray() throws MOException {

    String idContent = super.getIds();
    // Create array representation of split ratios ids indexed by dt
    try {
      idArray = new ArrayList<Long>();
      // if id content value exists populate ratioArray arraylist from string
      if (idContent != null) {
        String[] contentArray = idContent.split(",");
        // For each value separated by a comma, add it to content array
        for (int i = 0; i < contentArray.length; i++) {
          idArray.add(Long.valueOf(contentArray[i].trim()));
        }
      }
    }
    catch (Exception ex) {
      throw new MOException(ex,
          "Invalid id content string. Should be a comma separated string of long values.");
    }
  }

  /**
   * Set modStampArray arraylist based on modStamp content string
   * @throws MOException
   *
   */
  private void setModStampArray() throws MOException {

    String modStampContent = super.getModStamps();
    // Create array representation of split ration modstamps indexed by dt
    try {
      modStampArray = new ArrayList<String>();

      if (modStampContent != null) {
        // if modStamp content exists populate modStampArray arraylist from string
        String[] contentArray = modStampContent.split(",");
        // For each value separated by a comma, add it to content array
        for (int i = 0; i < contentArray.length; i++) {
          modStampArray.add(contentArray[i].trim());
        }
      }
    }
    catch (Exception ex) {
      throw new MOException(ex,
          "Invalid modStamp content string. Should be a comma separated string of String date values.");
    }
  }

  /**
   * Set crudFlagArray arraylist based on crudFlag content string
   * @throws MOException
   *
   */
  private void setCrudFlagArray() throws MOException {

    String crudFlagContent = super.getCrudFlags();
    // Create array representation of split ratio crudFlags indexed by dt
    try {
      crudFlagArray = new ArrayList<CrudFlag>();

      if (crudFlagContent != null) {
        // if CrudFlag content exists populate crudFlagArray arraylist from string
        String[] contentArray = crudFlagContent.split(",");
        // For each value separated by a comma, add it to content array
        for (int i = 0; i < contentArray.length; i++) {
          crudFlagArray.add(CrudFlag.valueOf(contentArray[i].trim()));
        }
      }
    }
    catch (Exception ex) {
      throw new MOException(ex,
          "Invalid CrudFlag content string. Should be a comma separated string of String date values.");
    }
  }
	
	/**
	 * Returns true if the linkInId, linkOutId, and vehTypeId all match
	 * the corresponding fields of this object
	 * 
	 * @return boolean 
	 */
	public boolean equals(long linkInId, long linkOutId,long vehTypeId){
		return linkInId == this.getLinkIn() && linkOutId == this.getLinkOut() && vehTypeId == this.getVehicleTypeId();
	}
	
	/**
	 * Checks to make sure the object is correct
	 * @return boolean
	 */
	public boolean isValid(){
    // TODO work on validation logic
		return true;
	}
}
