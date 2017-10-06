package shape.Polygon;

import shape.Point2D.Point2D;

public class AxesAlignedSquare extends AxesAlignedRectangle {

	public AxesAlignedSquare(String name, Point2D p1, double cote){
		super(name, p1, cote, cote);
	}

	public double getCote(){
		return super.getLongueur();
	}

	public void setCote(double cote){
		super.setLongueur(cote);
		super.setHauteur(cote);
	}

	public void setLongueur(double cote){
		this.setCote(cote);
	}

	public void setHauteur (double cote){
		this.setCote(cote);
	}

	public void print(){
		System.out.println(this);
	}

	public String toString(){
		return "AxesAlignedSquare (" + name + "(" + this.getOrigin().getX() + ", " + this.getOrigin().getY() + "), " + this.getLongueur() + ")";
	}
}
