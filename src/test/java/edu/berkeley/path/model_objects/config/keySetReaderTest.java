package edu.berkeley.path.model_objects.config;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Created by bill on 4/15/15.
 */
public class keySetReaderTest {

    @Test
    public void setKeySet() {

        ArrayList<ConfigKeyType> keySet = new ArrayList<ConfigKeyType> ();
        ConfigKeyType key = new ConfigKeyType();

        key.setId(1L);
        key.setName("A Key Name");
        key.setModStamp("01-JAN-1014 13:22:00.123456");
        key.setDescription("A Key Description");
        key.setInUse(1L);

        keySet.add(key);


        assertEquals(1, keySet.get(0).getId());
        assertEquals("a key name",key.getName().toLowerCase());
        assertEquals("a key description",key.getDescription().toLowerCase());
        assertEquals("01-JAN-1014 13:22:00.123456",key.getModStamp());
        assertEquals(1,key.getInUse());





        }

}
