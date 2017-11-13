

public class Triangle {
  private Point2D A, B, C;
  private int r,g,b;

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
  
  public String getColor() {
		return "(" + r + ", " + g + ", " + b + ")\n";
	}
	
	public void setColor(int r, int g, int b){
		this.r = r;
		this.g = g;
		this.b = b;
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
  
  public String svg(){
		return "<polygon points='" + A.getX()+ "," + A.getY() + " " + B.getX()+ "," + B.getY() + " " + C.getX() + "," + C.getY() + "' fill='rgb(" + r + "," + g + "," + b + ")' />";
	}
  
  public Point2D[] vertices() {
		Point2D[] myvertices = new Point2D[3];
		myvertices[0] = A;
		myvertices[1] = B;
		myvertices[2] = C;
		return myvertices;
	}
}
