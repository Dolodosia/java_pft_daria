package pl.stqa.pft.sandbox;

public class MyFirstProgram
{
	
	public static void main(String[] args){
		hello("world");
		hello("user");
		hello("Alexei");

		Square s = new Square(5);
      System.out.println("powierzchnia kwadratu o boku " + s.l + " = " + s.area());

      double a = 4;
      double b = 6;
      System.out.println("Powierzchnia prostokata o bokach " + a + " i " + b + " = " + area(a,b));
  }

  public static void hello(String somebody){
      System.out.println("Hello, " + somebody + " ! ");
  }

  public static double area(double len){
      return len*len;
  }

  public static double area(double a, double b){
      return a*b;
  }
	
}