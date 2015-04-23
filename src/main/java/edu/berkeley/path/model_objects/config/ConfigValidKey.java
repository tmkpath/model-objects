package edu.berkeley.path.model_objects.config;

import edu.berkeley.path.model_objects.shared.CrudFlag;

/**
 * Created by bill on 4/15/15.
 *
 */
public class ConfigValidKey extends edu.berkeley.path.model_objects.jaxb.ConfigValidKey {


    @Override
    public void setId(Long value) {
        super.setId(value);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setKeyFuncType(Long value) {
        super.setKeyFuncType(value);
    }

    @Override
    public Long getKeyFuncType() {
        return super.getKeyFuncType();
    }

    @Override
    public void setKeyName(String value) {
        super.setKeyName(value);
    }

    @Override
    public String getKeyName() {
        return super.getKeyName();
    }

    @Override
    public void setRequired(long value) {
        super.setRequired(value);
    }

    @Override
    public long getRequired() {
        return super.getRequired();
    }

    @Override
    public void setDefaultValue(String value) {
        super.setDefaultValue(value);
    }

    @Override
    public String getDefaultValue() {
        return super.getDefaultValue();
    }

    @Override
    public void setNumericMin(Double value) {
        super.setNumericMin(value);
    }

    @Override
    public Double getNumericMin() {
        return super.getNumericMin();
    }

    @Override
    public void setNumericMax(Double value) {
        super.setNumericMax(value);
    }

    @Override
    public Double getNumericMax() {
        return super.getNumericMax();
    }

    @Override
    public void setKeyType(long value) {
        super.setKeyType(value);
    }

    @Override
    public long getKeyType() {
        return super.getKeyType();
    }

    @Override
    public void setShortDesc(String value) {
        super.setShortDesc(value);
    }

    @Override
    public String getShortDesc() {
        return super.getShortDesc();
    }

    @Override
    public void setLongDesc(String value) {
        super.setLongDesc(value);
    }

    @Override
    public String getLongDesc() {
        return super.getLongDesc();
    }

    @Override
    public void setModStamp(String value) {
        super.setModStamp(value);
    }

    @Override
    public String getModStamp() {
        return super.getModStamp();
    }

    @Override
    public void setCrudflag(String value) {
        super.setCrudflag(value);
    }

    @Override
    public String getCrudflag() {
        return super.getCrudflag();
    }


    /**
     * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
     *
     * @return CRUD Flag enumeration
     */
    public CrudFlag getCrudFlagEnum() {

        CrudFlag flag = null;
        // Check if CRUDFlag is null, if so return NONE enumeration
        if (super.getCrudflag() == null) {
            setCrudFlagEnum(CrudFlag.NONE);
            flag = CrudFlag.NONE;
        }
        else {
            switch (CrudFlag.valueOf(super.getCrudflag())) {
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
            super.setCrudflag("NONE");
        } else {
            switch (flag) {
                case CREATE:
                    super.setCrudflag("CREATE");
                    break;
                case RETRIEVE:
                    super.setCrudflag("RETRIEVE");
                    break;
                case UPDATE:
                    super.setCrudflag("UPDATE");
                    break;
                case DELETE:
                    super.setCrudflag("DELETE");
                    break;
                default:
                    super.setCrudflag("NONE");
                    break;

            }
        }
    }
}
