package pl.stqa.pft.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTestNegative {
  @Test
  public void testDistance() {
    Point p1 = new Point(3, 4);
    Point p2 = new Point(5, 5);
    Assert.assertEquals(p1.distance(p2), 3.605551275463989);
  }
}
