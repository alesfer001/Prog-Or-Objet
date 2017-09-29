public class Triangle extends Shape2D {
  private Point2D A, B, C;

  public Triangle(Point2D A, Point2D B, Point2D C){
    this.A = A;
    this.B = B;
    this.C = C;
  }

  public Point2D getA(){
    return this.A;
  }

  public Point2D getB(){
    return this.B;
  }

  public Point2D getC(){
    return this.C;
  }

  public void setA(Point2D A){
    this.A = A;
  }

  public void setB(Point2D B){
    this.B = B;
  }

  public void setC(Point2D C){
    this.C = C;
  }

  public void print(){
    System.out.println(this);
  }

  public double area(){
    double a = A.distance(B);
    double b = B.distance(C);
    double c = C.distance(A);
    double p = (a + b + c) / 2;
    return Math.sqrt(p * (p-a) * (p-b) * (p-c));
  }

  public double perimeter(){
    double a = A.distance(B);
    double b = B.distance(C);
    double c = C.distance(A);
    return a + b + c;
  }

  public String toString(){
    return "Triangle ((" + A.getX() + ", " + A.getY() + "), (" + B.getX() + ", " + B.getY() + "), (" + C.getX() + ", " + C.getY() + "))";
  }
}
