package edu.berkeley.path.model_objects.dynamic;

import edu.berkeley.path.model_objects.MOException;
import edu.berkeley.path.model_objects.TestConfiguration;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.shared.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class DynamicDemandSetTest {

  private static final long PROJECT_ID = 10;
  private static final int APP_RUN_ID = 20;
  private static final String DESCRIPTION = "Test Set";
  private static final String NAME = "Test Set Name";

  private static final long ID = 1;
  private static final long MS = System.currentTimeMillis();
  private static final String MOD_STAMP = "01-APR-1982 23:23:12";


  private DynamicDemandSet set;

  @Before
  public void setUp() throws MOException {

    // Create Demand Set Object
    set = new DynamicDemandSet();
    set.setDescription(DESCRIPTION);
    set.setProjectId(PROJECT_ID);
    set.setId(ID);
    set.setName(NAME);
    set.setModStamp(MOD_STAMP);
    set.setAppRunId(APP_RUN_ID);
    DateTime dt = new DateTime();
    dt.setMilliseconds(MS);
    set.setEstTstamp(dt);
    set.setLockedForEdit(true);
    set.setLockedForHistory(true);

    // Create Demand Profile Objects which have demands associated with them
    List<DynamicDemandProfile> profiles = new ArrayList<DynamicDemandProfile>();
    profiles.add(TestConfiguration.createDynamicDemandProfile(1, 3600, 300, 1, CrudFlag.UPDATE));
    profiles.add(TestConfiguration.createDynamicDemandProfile(2, 3660, 300, 2, CrudFlag.UPDATE));
    profiles.add(TestConfiguration.createDynamicDemandProfile(3, 3720, 300, 3, CrudFlag.UPDATE));

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
    assertEquals(APP_RUN_ID, set.getAppRunId());

    assertEquals(MS, set.getEstTstamp().getMilliseconds());
    assertEquals(true, set.isLockedForEdit());
    assertEquals(true, set.isLockedForHistory());
    assertEquals(3, set.getListOfDemandProfiles().size());
  }

  @Test
  public void testGetDemandProfileAtLink() {
    DynamicDemandProfile profile = set.getDemandProfileAtLink(ID);
    assertEquals(ID, profile.getLinkIdOrg());

    profile = set.getDemandProfileAtLink(1111);
    assertNull(profile);
  }

}
