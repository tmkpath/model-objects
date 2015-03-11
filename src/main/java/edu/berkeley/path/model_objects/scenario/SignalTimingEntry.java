package edu.berkeley.path.model_objects.scenario;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmk on 8/6/14.
 */
public class SignalTimingEntry extends edu.berkeley.path.model_objects.jaxb.SignalTimingEntry {
    public List<SignalTimingElement> getListOfSignalTimingElements() {
        return (List<SignalTimingElement>)(List<?>) super.getSignalTimingElement();
    }

    public void setListOfSignalTimingElements(List<SignalTimingElement> elements) {
        getListOfSignalTimingElements().clear();
        getListOfSignalTimingElements().addAll(elements);
    }

    @Override
    public String getModStamp() {
        return super.getModStamp();
    }

    @Override
    public void setModStamp(String value) {
        super.setModStamp(value);
    }

    @Override
    public String getCrudFlag() {
        return super.getCrudFlag();
    }

    @Override
    public void setCrudFlag(String value) {
        super.setCrudFlag(value);
    }

    @Override
    public int getOrder() {
        return super.getOrder();
    }

    @Override
    public void setOrder(int value) {
        super.setOrder(value);
    }

    @Override
    public long getTimeStepMs() {
        return super.getTimeStepMs();
    }

    @Override
    public void setTimeStepMs(long value) {
        super.setTimeStepMs(value);
    }

    /**
     * Override Jaxb getters for children to manage Json serialization
     */
    @Override
    @JsonIgnore
    public List<edu.berkeley.path.model_objects.jaxb.SignalTimingElement> getSignalTimingElement() {
        if (signalTimingElement == null) {
            signalTimingElement = new ArrayList<edu.berkeley.path.model_objects.jaxb.SignalTimingElement>();
        }
        return this.signalTimingElement;
    }
}