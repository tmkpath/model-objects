package edu.berkeley.path.model_objects;

import java.util.ArrayList;
import java.util.List;

import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.scenario.SplitRatioProfile;
import edu.berkeley.path.model_objects.scenario.Splitratio;

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

}
