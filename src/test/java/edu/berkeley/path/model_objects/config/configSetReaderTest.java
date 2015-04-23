package edu.berkeley.path.model_objects.config;



import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


/**
 * Created by bill on 4/16/15.
 *
 */
public class configSetReaderTest {

    @Test
    public void configSetTest() {

        ArrayList<ConfigType> keySet = new ArrayList<ConfigType> ();
        ConfigType key = new ConfigType();

        key.setId(1L);
        key.setName("Le Grand Test");
        key.setDescription("Le Grand Description");
        key.setInUse(1);
        key.setModStamp("01-DEC-2014 23:31:12.12341234");
        key.setCrudflag("UPDATE");

        keySet.add(key);

        assertEquals(1,keySet.get(0).getId().longValue());
        assertEquals("le grand test",keySet.get(0).getName().toLowerCase());
        assertEquals("le grand description",keySet.get(0).getDescription().toLowerCase());
        assertEquals(1,keySet.get(0).getInUse());
        assertEquals("01-DEC-2014 23:31:12.12341234",keySet.get(0).getModStamp());
        assertEquals("UPDATE",keySet.get(0).getCrudflag());


    }


}
