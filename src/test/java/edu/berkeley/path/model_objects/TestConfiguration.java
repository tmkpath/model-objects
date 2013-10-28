package edu.berkeley.path.model_objects;

import edu.berkeley.path.model_objects.dynamic.DynamicDemand;
import edu.berkeley.path.model_objects.dynamic.DynamicDemandProfile;
import edu.berkeley.path.model_objects.dynamic.DynamicSplitRatio;
import edu.berkeley.path.model_objects.dynamic.DynamicSplitRatioProfile;
import edu.berkeley.path.model_objects.scenario.Demand;
import edu.berkeley.path.model_objects.scenario.DemandProfile;
import edu.berkeley.path.model_objects.scenario.SplitRatioProfile;
import edu.berkeley.path.model_objects.scenario.Splitratio;
import edu.berkeley.path.model_objects.shared.CrudFlag;

import java.util.ArrayList;
import java.util.List;

public class TestConfiguration {
	
	public static SplitRatioProfile createSplitRatioProfile(int nodeId, double start, double dt, long dest, CrudFlag flag ) throws MOException {
		SplitRatioProfile profile = new SplitRatioProfile();
		profile.setNodeId(nodeId);
		profile.setStartTime(start);
		profile.setDt(dt);
		profile.setDestinationNetworkId(dest);
		profile.setCrudFlagEnum(flag);
		
		List<Splitratio> ratios = new ArrayList<Splitratio>();
		
		ratios.add(createSplitRatio(1,2,3,"0.5,0.1,1.0,0.6"));
		profile.setListOfSplitRatios(ratios);
		
		return profile;
	}

  public static Splitratio createSplitRatio(int link_in, int link_out, int veh_id, String ratios ) throws MOException {
    Splitratio r = new Splitratio();
    r.setLinkIn(link_in);
    r.setLinkOut(link_out);
    r.setVehicleTypeId(veh_id);
    r.setContent(ratios);
    return r;
  }
	
	public static DynamicSplitRatio createDynamicSplitRatio(int link_in, int link_out, int veh_id, String ratios ) throws MOException {
    DynamicSplitRatio r = new DynamicSplitRatio();
    r.setLinkIn(link_in);
    r.setLinkOut(link_out);
    r.setVehicleTypeId(veh_id);
    r.setContent(ratios);
    return r;
  }

  public static DynamicSplitRatioProfile createDynamicSplitRatioProfile(int nodeId, double start, double dt, long dest, CrudFlag flag ) throws MOException {
    DynamicSplitRatioProfile profile = new DynamicSplitRatioProfile();
    profile.setNodeId(nodeId);
    profile.setStartTime(start);
    profile.setDt(dt);
    profile.setDestinationNetworkId(dest);
    profile.setCrudFlagEnum(flag);

    List<DynamicSplitRatio> ratios = new ArrayList<DynamicSplitRatio>();

    ratios.add(createDynamicSplitRatio(1,2,3,"0.5,0.1,1.0,0.6"));
    profile.setListOfSplitRatios(ratios);

    return profile;
  }



  public static DemandProfile createDemandProfile(int linkId, double start, double dt, long dest, CrudFlag flag ) throws MOException {
    DemandProfile profile = new DemandProfile();
    profile.setLinkIdOrg(linkId);
    profile.setStartTime(start);
    profile.setDt(dt);
    profile.setDestinationNetworkId(dest);
    profile.setCrudFlagEnum(flag);

    List<Demand> demands = new ArrayList<Demand>();

    demands.add(createDemand(1,"0.5,0.1,1.0,0.6"));
    demands.add(createDemand(2,"0.5,0.1,1.0,0.6"));
    profile.setListOfDemands(demands);

    return profile;
  }

  public static Demand createDemand(int veh_id, String demands ) throws MOException {
    Demand r = new Demand();
    r.setVehicleTypeId(veh_id);
    r.setContent(demands);
    return r;
  }

  public static DynamicDemandProfile createDynamicDemandProfile(int linkId, double start, double dt, long dest, CrudFlag flag ) throws MOException {
    DynamicDemandProfile profile = new DynamicDemandProfile();
    profile.setLinkIdOrg(linkId);
    profile.setStartTime(start);
    profile.setDt(dt);
    profile.setDestinationNetworkId(dest);
    profile.setCrudFlagEnum(flag);

    List<DynamicDemand> demands = new ArrayList<DynamicDemand>();

    demands.add(createDynamicDemand(1,"0.5,0.1,1.0,0.6"));
    demands.add(createDynamicDemand(2,"0.5,0.1,1.0,0.6"));
    profile.setListOfDemands(demands);

    return profile;
  }

  public static DynamicDemand createDynamicDemand(int veh_id, String demands ) throws MOException {
    DynamicDemand r = new DynamicDemand();
    r.setVehicleTypeId(veh_id);
    r.setContent(demands);
    return r;
  }
}
