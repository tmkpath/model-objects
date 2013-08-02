package edu.berkeley.path.model_objects.scenario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.ArrayList;

import edu.berkeley.path.model_objects.TestConfiguration;
import org.junit.Before;
import org.junit.Test;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.MOException;


public class DemandSetTest {

  private static final long PROJECT_ID = 10;
  private static final String DESCRIPTION = "Test Set";
  private static final String NAME = "Test Set Name";

  private static final long ID = 1;
  private static final String MOD_STAMP = "01-APR-1982 23:23:12";

  private DemandSet set;

  @Before
  public void setUp() throws MOException {

    // Create Demand Set Object
    set = new DemandSet();
    set.setDescription(DESCRIPTION);
    set.setProjectId(PROJECT_ID);
    set.setId(ID);
    set.setName(NAME);
    set.setModStamp(MOD_STAMP);
    set.setLockedForEdit(true);
    set.setLockedForHistory(true);

    // Create Demand Profile Objects which have demands associated with them
    List<DemandProfile> profiles = new ArrayList<DemandProfile>();
    profiles.add(TestConfiguration.createDemandProfile(1, 3600, 300, 1, CrudFlag.UPDATE));
    profiles.add(TestConfiguration.createDemandProfile(2, 3660, 300, 2, CrudFlag.UPDATE));
    profiles.add(TestConfiguration.createDemandProfile(3, 3720, 300, 3, CrudFlag.UPDATE));

    // Add demand profiles to set
    set.setListOfDemandProfiles(profiles);
  }

  @Test
  public void testGetters() {
    assertEquals(DESCRIPTION, set.getDescription());
    assertEquals(PROJECT_ID, set.getProjectId());
    assertEquals(ID,set.getId());
    assertEquals(NAME, set.getName());
    assertEquals(MOD_STAMP, set.getModStamp());
    assertEquals(true, set.isLockedForEdit());
    assertEquals(true, set.isLockedForHistory());
    assertEquals(3, set.getListOfDemandProfiles().size());
  }

  @Test
  public void testGetDemandProfileAtLink() {
    DemandProfile profile = set.getDemandProfileAtLink(ID);
    assertEquals(ID, profile.getLinkIdOrg());

    profile = set.getDemandProfileAtLink(1111);
    assertNull(profile);
  }

}
