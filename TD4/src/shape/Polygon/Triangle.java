package shape.Polygon;

import shape.Point2D.Point2D;

public class Triangle extends Polygone {
	private Point2D A, B, C;

	public Triangle(String name, Point2D A, Point2D B, Point2D C){
		this.name = name;
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
	
	public void setzIndex(int z){
		if(z >= 0 && z <=100){
			zIndex = z;			
		}
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
		return "Triangle (" + name + "(" + A.getX() + ", " + A.getY() + "), (" + B.getX() + ", " + B.getY() + "), (" + C.getX() + ", " + C.getY() + "))";
	}

	public void translate(double dx, double dy) {
		this.A.translate(dx,dy);
		this.B.translate(dx,dy);
		this.C.translate(dx,dy);
	}

	public void translate(double delta) {
		this.A.translate(delta);
		this.B.translate(delta);
		this.C.translate(delta);
	}
	
	public boolean equals(Triangle t) {
		if(t == null) {
			return false;
		}
		else if(t instanceof Triangle) {
			return name.equals(t.name) && A.equals(t.A) && B.equals(t.B) && C.equals(t.C);
		}
		else {
			return false;
		}
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
