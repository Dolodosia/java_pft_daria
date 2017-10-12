package pl.stqa.pft.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointDistancetest2 {
  @Test
  public void testDistance() {
    Point p5 = new Point(8, 8);
    Point p6 = new Point(5, 5);
    Assert.assertEquals(p5.distance(p6), 3.605551275463989);
  }
}

