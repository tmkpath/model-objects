package edu.berkeley.path.model_objects.config;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by bill on 4/15/15.
 */
public class ConfigValidKeySet extends edu.berkeley.path.model_objects.jaxb.ConfigValidKeySet{

    public List<ConfigValidKey> getValidKeySet() {
        return (List<ConfigValidKey>) (List<?>) super.getConfigValidKey();
    }


    /**
     * Set the parameters list. Attaches list of Parameter Model Objects to scenario.
     *
     * @param  confKeyTypes	List of extended Config Key Types to add
     */
    public void setListOfValidKeys(List<ConfigValidKey> confKeyTypes) {

        List<edu.berkeley.path.model_objects.jaxb.ConfigValidKey> pSet =
                (ArrayList<edu.berkeley.path.model_objects.jaxb.ConfigValidKey>) configValidKey ;

        if ( pSet == null )
            pSet = new ArrayList<edu.berkeley.path.model_objects.jaxb.ConfigValidKey>();

        pSet.clear();
        pSet.addAll(confKeyTypes);
        configValidKey = pSet;
    }

}
