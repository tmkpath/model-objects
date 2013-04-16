package edu.berkeley.path.model_objects.scenario;

import edu.berkeley.path.model_objects.shared.DateTime;

public class PIFProbeData extends edu.berkeley.path.model_objects.jaxb.PIFProbeData{

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getTimestamp() {
        return (DateTime) super.getTimestamp();
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setTimestamp(DateTime value) {
        super.setTimestamp(value);
    }

    /**
     * Gets the value of the networkId property.
     * 
     */
    public long getNetworkId() {
        return super.getNetworkId();
    }

    /**
     * Sets the value of the networkId property.
     * 
     */
    public void setNetworkId(long value) {
        super.setNetworkId(value);
    }

    /**
     * Gets the value of the linkId property.
     * 
     */
    public long getLinkId() {
        return super.getLinkId();
    }

    /**
     * Sets the value of the linkId property.
     * 
     */
    public void setLinkId(long value) {
        super.setLinkId(value);
    }

    /**
     * Gets the value of the runId property.
     * 
     */
    public long getRunId() {
        return super.getRunId();
    }

    /**
     * Sets the value of the runId property.
     * 
     */
    public void setRunId(long value) {
        super.setRunId(value);
    }

    /**
     * Gets the value of the offset property.
     * 
     */
    public double getOffset() {
        return super.getOffset();
    }

    /**
     * Sets the value of the offset property.
     * 
     */
    public void setOffset(double value) {
        super.setOffset(value);
    }

    /**
     * Gets the value of the speed property.
     * 
     */
    public double getSpeed() {
        return super.getSpeed();
    }

    /**
     * Sets the value of the speed property.
     * 
     */
    public void setSpeed(double value) {
        super.setSpeed(value);
    }

    /**
     * Gets the value of the probability property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getProbability() {
        return super.getProbability();
    }

    /**
     * Sets the value of the probability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setProbability(Double value) {
        super.setProbability(value);
    }

}
