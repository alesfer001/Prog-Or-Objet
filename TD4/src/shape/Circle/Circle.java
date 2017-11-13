package shape.Circle;

import shape.Shape2D;
import shape.Point2D.Point2D;

public class Circle extends Shape2D {
	private Point2D centre;
	private double rayon;

	public Circle(String name, Point2D centre, double rayon){
		this.name = name;
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
	
	public void setzIndex(int z){
		if(z >= 0 && z <=100){
			zIndex = z;			
		}
	}

	public void translate(double dx, double dy){
		this.centre.translate(dx, dy);
	}

	public void translate(double delta){
		this.centre.translate(delta, delta);
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
	
	public boolean equals(Circle c) {
		if(c == null) {
			return false;
		}
		else if(c instanceof Circle) {
			return name.equals(c.name) && centre.equals(c.centre) && rayon == c.rayon;
		}
		else {
			return false;
		}
	}

	public String toString(){
		return "Circle (" + name + "(" + centre.getX() + ", " + centre.getY() + "), "  + rayon + ")";
	}
	
	public String svg(){
		return "<circle cx='" + centre.getX() + "' cy='"+ centre.getY() + "' r='" + rayon + "' fill='rgb(" + r + "," + g + "," + b + ")' />";
	}
}
