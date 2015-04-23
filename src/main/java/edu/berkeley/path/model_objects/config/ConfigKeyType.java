package edu.berkeley.path.model_objects.config;


import edu.berkeley.path.model_objects.jaxb.*;
import edu.berkeley.path.model_objects.shared.CrudFlag;

/**
 * Created by bill on 4/14/15.
 * 
 */
public class ConfigKeyType extends edu.berkeley.path.model_objects.jaxb.ConfigKeyType {


    @Override
    public long getId() {return super.id ;}

    @Override
    public long getInUse() {return super.inUse; }

    @Override
    public String getCrudflag() {
        return super.getCrudflag();
    }

    @Override
    public String getDescription() { return super.getDescription(); }

    @Override
    public String getModStamp() { return super.getModStamp(); }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setCrudflag(String value) {
        super.setCrudflag(value);
    }

    @Override
    public void setId(long value) {
        super.setId(value);
    }

    @Override
    public void setInUse(long value) {
        super.setInUse(value);
    }

    @Override
    public void setModStamp(String value) {
        super.setModStamp(value);
    }

    @Override
    public void setName(String value){super.setName(value);}

    @Override
    public void setDescription(String value){super.setDescription(value);}

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
