public class Circle extends Shape2D {
  private Point2D centre;
  private double rayon;

  public Circle(Point2D centre, double rayon){
    this.centre = centre;
    this.rayon = rayon;
  }

  public Point2D getCentre(){
    return this.centre;
  }

  public double getRayon(){
    return this.rayon;
  }

  public void setCentre(Point2D point){
    this.centre = point;
  }

  public void setRayon(double r){
    this.rayon = r;
  }

  public void translate(double dx, double dy){
    this.centre.translate(dx, dy);
  }

  public void print(){
    System.out.println(this);
  }

  public double area(){
    return Math.PI * rayon * rayon;
  }

  public double perimeter(){
    return 2 * Math.PI * rayon;
  }

  public String toString(){
    return "Circle ((" + centre.getX() + ", " + centre.getY() + "), "  + rayon + ")";
  }
}
