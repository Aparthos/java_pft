package pl.stqa.pft.sandbox;

public class Point {


  private double x;
  private double y;

  Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getDistance(Point p) {

    return Math.sqrt((this.getX() - p.getX()) * (this.getX() - p.getX())
            + (this.getY() - p.getY()) * (this.getY() - p.getY()));
  }

  public static void main(String[] args) {

    System.out.println("Zadanie domowe, Kamil Malinowski");

    Point px = new Point(3, 3);

    Point py = new Point(8, 8);

    double distance = px.getDistance(py);

    System.out.println("odległość pomiędzy punktami px oraz py wynosi " + distance);
  }


}






