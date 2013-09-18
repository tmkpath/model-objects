package edu.berkeley.path.model_objects.traffic_state;

import edu.berkeley.path.model_objects.jaxb.AggregationType;
import edu.berkeley.path.model_objects.jaxb.ApplicationType;
import edu.berkeley.path.model_objects.jaxb.QuantityType;
import edu.berkeley.path.model_objects.shared.DateTime;

public class LinkState extends edu.berkeley.path.model_objects.jaxb.LinkState {

  public long getApplicationTypeId() {
		return getApplicationType().getId();
	}

	public void setApplicationType(long id, String name, String desc) {
		ApplicationType type = new ApplicationType();
		type.setId(id);
		type.setName(name);
		type.setDescription(desc);
    setApplicationType(type);
	}

	public long getAggregationTypeId() {
		return getAggregationType().getId();
	}

	public void setAggregationType(long id, String name, String desc) {
		AggregationType type = new AggregationType();
		type.setId(id);
		type.setName(name);
		type.setDescription(desc);
    setAggregationType(type);
	}

	public long getQuantityTypeId() {
		return getQuantityType().getId();
	}

	public void setQuantityType(long id, String name, String desc) {
		QuantityType type = new QuantityType();
		type.setId(id);
		type.setName(name);
		type.setDescription(desc);
    setQuantityType(type);
	}

	public void populate() {
		//TODO generate actual implementation
	}

	public boolean isValid() {
		//TODO generate actual implementation
		return true;
	}

  @Override
	public DateTime getTimestamp() {
		return  new DateTime(super.getTimestamp().getMilliseconds());
	}

	public void setTimestamp(DateTime value) {
		super.setTimestamp(value);
	}

	@Override
	public long getId() {
		return super.getId();
	}

	@Override
	public void setId(long value) {
		super.setId(value);
	}

	@Override
	public Long getNetworkId() {
		return super.getNetworkId();
	}

	@Override
	public void setNetworkId(Long value) {
		super.setNetworkId(value);
	}

	@Override
	public Long getRunId() {
		return super.getRunId();
	}

	@Override
	public void setRunId(Long value) {
		super.setRunId(value);
	}

	@Override
	public Double getDt() {
		return super.getDt();
	}

	@Override
	public void setDt(Double value) {
		super.setDt(value);
	}

	@Override
	public Double getFfSpeed() {
		return super.getFfSpeed();
	}

	@Override
	public void setFfSpeed(Double value) {
		super.setFfSpeed(value);
	}

	@Override
	public Double getCritSpeed() {
		return super.getCritSpeed();
	}

	@Override
	public void setCritSpeed(Double value) {
		super.setCritSpeed(value);
	}

	@Override
	public Double getCapacity() {
		return super.getCapacity();
	}

	@Override
	public void setCapacity(Double value) {
		super.setCapacity(value);
	}
}
