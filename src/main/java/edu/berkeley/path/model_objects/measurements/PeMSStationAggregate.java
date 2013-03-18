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

package edu.berkeley.path.model_objects.measurements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import edu.berkeley.path.model_objects.jaxb.PeMSAggregate;
import edu.berkeley.path.model_objects.jaxb.PeMSDatum;
import edu.berkeley.path.model_objects.shared.DateTime;

/** 
 * Model Object PeMS Station Aggregate class
 *  
 * @author Gunes Dervisoglu (gunesder@berkeley.edu)
 */
public class PeMSStationAggregate extends edu.berkeley.path.model_objects.jaxb.PeMSStationAggregate{
	
	/**
	 * TODO: Validation
	 * TODO: Readers and Writers
	 * TODO: Unit Tests
	 */
	
	/** @y.exclude */ protected PeMSAggregate total;
	/** @y.exclude */ protected List<PeMSAggregate> byLane;
	/** @y.exclude */ protected Map<String,Double> delay;
	
	/**
	 * Gets the value of the 'total' field.
	 * Aggregated at this station, across lanes.
	 */
	public PeMSAggregate getTotal() {
	    return total;
	}

	/**
	 * Sets the value of the 'total' field.
	 * Aggregated at this station, across lanes.
	 * @param value the value to set.
	 */
    public void setTotal(PeMSAggregate value) {
	    this.total = value;
	}
    
    /**
     * Gets the value of the 'byLane' field.
     * Aggregated by lane at this station.
     * Field is null for 1 day aggregates.
     */
    public List<PeMSAggregate> getByLane() {
      return byLane;
    }

    /**
     * Sets the value of the 'byLane' field.
     * Aggregated by lane at this station.
     * Field is null for 1 day aggregates.
     * @param value the value to set.
     */
    public void setByLane(List<PeMSAggregate> value) {
      this.byLane = value;
    }
    
    /**
     * Gets the value of the 'delay' field.
     * Average delay over the station length, for a threshold speed.
     * Keys are speeds in mph: "35", "40", ... "60".
     * Field is null for 5 minute aggregates.
     */
    public Map<String,Double> getDelay() {
      return delay;
    }

    /**
     * Sets the value of the 'delay' field.
     * Average delay over the station length, for a threshold speed.
     * Keys are speeds in mph: "35", "40", ... "60".
     * Field is null for 5 minute aggregates.
     * @param value the value to set.
     */
    public void setDelay(Map<String,Double> value) {
      this.delay = value;
    }
    
    /**
     * Set the list of aggregates by lane. Same as setByLane(), but works
     * with a list of PeMSAggregate.
     */
    @SuppressWarnings("unchecked")
    public void setByLaneList(List<edu.berkeley.path.model_objects.measurements.PeMSAggregate> byLane2) {
      setByLane((List<PeMSAggregate>)(List<?>)byLane2);
    }

    /**
     * Get the list of aggregates by lane. Same as getByLane(), but works
     * with a list of PeMSAggregate.
     * 
     * Never returns null (creates the list if it doesn't exist).
     */
    @SuppressWarnings("unchecked")
    public List<PeMSAggregate> getByLaneList() {
      if (null == getByLane()) {
        setByLane(new ArrayList<PeMSAggregate>());
      }
      return (List<PeMSAggregate>)(List<?>)getByLane();
    }
	
	/**
	 * Return list of PeMSAggregate objects (i.e. the profile)
	 * 
	 * @return list of PeMSAggregate objects as List<PeMSAggregate>
	 */
	@Override
	public List<PeMSAggregate> getPeMSAggregate() {
	  return super.getPeMSAggregate();
	}
	
	/**
	 * Set list of PeMSDatum objects (i.e. the profile)
	 * 
	 * @param peMSDatum list as List<PeMSDatum>
	 */
	public void setPeMSAggregate(List<PeMSAggregate> peMSAggregate) {
	  getPeMSAggregate().clear();
	  getPeMSAggregate().addAll(peMSAggregate);
	}
	
	/**
	 * Return VDS ID
	 * 
	 * @return VDS ID as long
	 */
	@Override
	public long getVdsId() {
	  return super.getVdsId();
	}
	
	/**
	 * Set VDS ID
	 * 
	 * @param VDS ID as long
	 */
	@Override
	public void setVdsId(long vdsId) {
	  super.setVdsId(vdsId);
	}
	
	/**
	 * Return timestamp of aggregate datum
	 * 
	 * @return timestamp of aggregate datum as XMLGregorianCalendar
	 */
	@Override
	public DateTime getTimestamp() {
	  return (DateTime) super.getTimestamp();
	}
	
	/**
	 * Set timestamp of aggregate datum
	 * 
	 * @param timestamp of aggregate datum as XMLGregorianCalendar
	 */
	//@Override
	public void setTimestamp(DateTime timestamp){
		super.setTimestamp(timestamp);
	}

}
