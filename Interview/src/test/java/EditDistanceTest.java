import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceTest {

   @Test
   public void testMethod() {
    EditDistance editDistance = new EditDistance();
    assertEquals(editDistance.minDistance("hello","llo"), 2);

   }
  }


