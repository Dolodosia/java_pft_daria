package pl.stqa.pft.sandbox;

public class Distance {

  public static void main(String[] args) {

  Point p1 = new Point(3,4);
  Point p2 = new Point(6,6);

		 System.out.println("Distance between Point1 (" + p1.x + ", " + p1.y + ") and Point2 ("
          + p2.x + ", " + p2.y + ") = " + p1.distance(p2) + ".");
}

		   }

