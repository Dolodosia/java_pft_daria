package pl.stqa.pft.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


  public class PointTest {
    @Test
    public void testDistance() {
      Point p1 = new Point(3,4);
      Assert.assertEquals(p1.distance(p2), 3.605551275463989);

    }
  }

}
