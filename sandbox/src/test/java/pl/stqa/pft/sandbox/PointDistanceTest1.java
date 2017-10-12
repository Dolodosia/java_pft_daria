package pl.stqa.pft.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointDistanceTest1 {
  @Test
  public void testDistance() {
    Point p3 = new Point(3, 4);
    Point p4 = new Point(6, 6);
    Assert.assertEquals(p3.distance(p4), 3.605551275463989);
  }
}
