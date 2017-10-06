package shape.Point2D;

import shape.Shape2D;

public class Point2D extends Shape2D {
	private double x, y;

	public Point2D(String name, double x, double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public Point2D(Point2D p){
		this(p.name, p.x, p.y);
	}

	public double getX(){
		return this.x;
	}

	public double getY(){
		return this.y;
	}

	public void setX(double x){
		this.x = x;
	}

	public void setY(double y){
		this.y = y;
	}

	public void translate(double dx, double dy) {
		this.x = this.x + dx;
		this.y = this.y + dy;
	}

	public void translate(double delta) {
		this.x+=delta;
		this.y+=delta;
	}

	public void print() {
		System.out.println(this);
	}

	public double distance(Point2D p){
		double d1 = p.x - x;
		double d2 = p.y - y;
		return Math.sqrt(d1*d1 + d2*d2);
	}
	
	public boolean equals(Point2D p) {
		if(p == null) {
			return false;
		}
		else if(p instanceof Point2D) {
			return name.equals(p.name) && x == p.x && y == p.y;
		}
		else {
			return false;
		}
	}

	public String toString() {
		return "Point2D (" + name + "(" + x + ", "  + y + "))";
	}

	public double area() {
		return 0;
	}

	public double perimeter() {
		return 0;
	}

}
