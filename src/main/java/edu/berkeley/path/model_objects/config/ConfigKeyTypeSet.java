package edu.berkeley.path.model_objects.config;

//import edu.berkeley.path.model_objects.jaxb.ConfigKeyTypeSet;


//import edu.berkeley.path.model_objects.jaxb.*;
//import edu.berkeley.path.model_objects.config.ConfigKeyTypes;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by bill on 4/14/15.
 */
public class ConfigKeyTypeSet extends edu.berkeley.path.model_objects.jaxb.ConfigKeyTypeSet {




    public List<ConfigKeyType> getListOfConfigKeyTypes() {
        return (List<ConfigKeyType>) (List<?>) super.getConfigKeyType();
    }


    /**
     * Set the parameters list. Attaches list of Parameter Model Objects to scenario.
     *
     * @param  confKeyTypes	List of extended Config Key Types to add
     */
    public void setListOfConfigKeyTypes(List<ConfigKeyType> confKeyTypes) {

        List<edu.berkeley.path.model_objects.jaxb.ConfigKeyType> pSet =
                (ArrayList<edu.berkeley.path.model_objects.jaxb.ConfigKeyType>)configKeyType;

        if ( pSet == null )
            pSet = new ArrayList<edu.berkeley.path.model_objects.jaxb.ConfigKeyType>();

        pSet.clear();
        pSet.addAll(confKeyTypes);
        configKeyType = pSet;
    }



}
