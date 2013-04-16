package edu.berkeley.path.model_objects.scenario;

import java.util.List;

import edu.berkeley.path.model_objects.scenario.PIFProbeData;

public class PIFProbeDataSet extends edu.berkeley.path.model_objects.jaxb.PIFProbeDataSet{
    /**
     * Gets the value of the pifProbeData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PIFProbeData }
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
    	this.pifProbeData = (List<edu.berkeley.path.model_objects.jaxb.PIFProbeData>)(List<?>)list;
    }

}
