package edu.berkeley.path.model_objects.shared;

import org.junit.*;
import static org.junit.Assert.*;
import edu.berkeley.path.model_objects.shared.DateTime;
import core.*;

import java.util.*;

public class DateTimeTest {
  DateTime dateTime;
  
  @Before
  public void setup() {
    // DateTime model object
    dateTime = new DateTime(100);
  }

  @Test
  public void testDateTime() {
    
    // Test the correct milliseconds are set
    long milliseconds = dateTime.getMilliseconds();
    assertEquals(milliseconds, 100);
    
    // Test setting date string and that it returns the expected milliseconds
    org.joda.time.DateTime joda = dateTime.setDateString("1970-01-01 00:00:00");
    long milliseconds1  = joda.getMillis();
    assertEquals(milliseconds1, 28800000);
    
    joda = dateTime.setDateString("1970-01-01 00:01:00");
    long milliseconds2  = joda.getMillis();
    assertEquals(milliseconds2, 28860000); 
    
    
  }
}