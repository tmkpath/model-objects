package edu.berkeley.path.model_objects.config;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by bill on 4/16/15.
 */
public class ConfigTypeSet extends edu.berkeley.path.model_objects.jaxb.ConfigTypeSet {


    public List<ConfigType> getConfigSet() {
        return (List<ConfigType>) (List<?>) super.configType;
    }

    /**
     * Set the parameters list. Attaches list of Parameter Model Objects to scenario.
     *
     * @param  confTypes List of extended Config Types
     * */
    public void setConfigSet(List<ConfigType> confTypes) {


        List<edu.berkeley.path.model_objects.jaxb.ConfigType> pSet =
                (ArrayList<edu.berkeley.path.model_objects.jaxb.ConfigType>)configType;

        if ( pSet == null )
            pSet = new ArrayList<edu.berkeley.path.model_objects.jaxb.ConfigType>();

        pSet.clear();
        pSet.addAll(confTypes);
        configType = pSet;



    }



}
