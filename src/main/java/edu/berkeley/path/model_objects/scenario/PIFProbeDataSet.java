package edu.berkeley.path.model_objects.scenario;

import java.util.ArrayList;
import java.util.List;

import edu.berkeley.path.model_objects.scenario.PIFProbeData;

public class PIFProbeDataSet extends edu.berkeley.path.model_objects.jaxb.PIFProbeDataSet{
    /**
     * Gets the value of the pifProbeData property.
     * 
     * @return List<PIFProbeData>
     * 
     * 
     */
    @SuppressWarnings("unchecked")
	public List<PIFProbeData> getPIFProbeDataList() {
        return (List<PIFProbeData>)(List<?>)super.getPIFProbeData();
    }
    
    /**
     * adds a PIFProbeData object to this sets list of PIFProbeData objects
     * 
     * @param PIFProbeData object to be added to list
     */
    public void setPIFProbeData(PIFProbeData data){
    	this.getPIFProbeData().add(data);
    }
    
    /**
     * adds a PIFProbeData list of objects to this method sets to the list of PIFProbeData objects
     * 
     * @param PIFProbeData object to be added to list
     */
    @SuppressWarnings("unchecked")
	public void setPIFProbeData(List<PIFProbeData> list){
    	if(this.pifProbeData == null)
    		this.pifProbeData = new ArrayList<edu.berkeley.path.model_objects.jaxb.PIFProbeData>();
    	this.pifProbeData = (List<edu.berkeley.path.model_objects.jaxb.PIFProbeData>)(List<?>)list;
    }

    /**
     * Gets the value of the lockedForEdit property.
     * 
     * @return boolean
     *     
     */
    @Override
    public boolean isLockedForEdit() {
       return super.isLockedForEdit();
    }

    /**
     * Sets the value of the lockedForEdit property.
     * 
     * @param Boolean value
     *     
     */
    @Override
    public void setLockedForEdit(Boolean value) {
    	super.setLockedForEdit(value);
    }

    /**
     * Gets the value of the lockedForHistory property.
     * 
     * @return boolean
     *     
     */
    @Override
    public boolean isLockedForHistory() {
       return super.isLockedForHistory();
    }

    /**
     * Sets the value of the lockedForHistory property.
     * 
     * @param Boolean value
     *     
     */
    @Override
    public void setLockedForHistory(Boolean value) {
    	super.setLockedForHistory(value);
    }
    
    /**
     * Used to ensure all probes are correctly instantiated
     * 
     * @return boolean
     */
    public boolean isValid(){
    	return true;
    }

}
