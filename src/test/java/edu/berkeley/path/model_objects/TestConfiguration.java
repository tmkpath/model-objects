package edu.berkeley.path.model_objects;

import java.util.ArrayList;
import java.util.List;

import edu.berkeley.path.model_objects.jaxb.CrudFlag;
import edu.berkeley.path.model_objects.scenario.SplitRatioProfile;
import edu.berkeley.path.model_objects.scenario.Splitratio;

public class TestConfiguration {
	
	public static SplitRatioProfile createSplitRatioProfile(int nodeId, int start, int dt, int dest, CrudFlag flag ){
		SplitRatioProfile profile = new SplitRatioProfile();
		profile.setNodeId(nodeId);
		profile.setStartTime(start);
		profile.setDt(dt);
		profile.setDestinationNetworkId(dest);
		profile.setCrudFlag(flag);
		
		List<Splitratio> ratios = new ArrayList<Splitratio>();
		
		ratios.add(createSplitRatio(1,2,3,0.5,0,CrudFlag.UPDATE));
		ratios.add(createSplitRatio(1,2,3,0.1,1,CrudFlag.UPDATE));
		ratios.add(createSplitRatio(1,2,3,1,2,CrudFlag.UPDATE));
		ratios.add(createSplitRatio(1,2,3,0.6,3,CrudFlag.UPDATE));
		profile.setListOfSplitRatios(ratios);
		
		return profile;
	}
	
	public static Splitratio createSplitRatio(int link_in, int link_out, int veh_id, double ratio, int order, CrudFlag flag) {
		Splitratio r = new Splitratio();
		r.setLinkIn(link_in);
		r.setLinkOut(link_out);
		r.setVehTypeId(veh_id);
		r.setContent(ratio + "");
		r.setRatioOrder(order);	
		r.setCrudFlag(flag);	
		return r;
		
	}

}
