

public class AxesAlignedRectangle extends Polygone {
  private double longueur, hauteur;
  private Point2D p1;

  public AxesAlignedRectangle(Point2D p1, double l, double h){
    this.p1 = p1;
    this.longueur = l;
    this.hauteur = h;
  }

  public Point2D getOrigin(){
    return this.p1;
  }

  public double getLongueur(){
    return this.longueur;
  }

  public double getHauteur(){
    return this.hauteur;
  }

  public void setLongueur(double l){
    this.longueur = l;
  }

  public void setHauteur(double h){
    this.hauteur = h;
  }

  public void print(){
    System.out.println(this);
  }

  public double area(){
    return longueur * hauteur;
  }

  public double perimeter(){
    return 2 * longueur + 2 * hauteur;
  }
  
  public boolean estInterieur(Point2D p) {
		return p.getX() - p1.getX() > 0 && p.getX() - p1.getX() <= longueur && p1.getY() - p.getY() > 0 && p1.getY() - p.getY() <= hauteur;
	}

  public String toString(){
    return "AxesAlignedRectangle ((" + p1.getX() + ", " + p1.getY() + "), " + longueur + ", "  + hauteur + ")";
  }
  
  public String svg(){
		return "<rect x='" + p1.getX() + "' y='" + p1.getY() + "' width='" + longueur + "' height='"+ hauteur + "' fill='rgb(" + r + "," + g + "," + b + ")' />";
	}
  
  public Point2D[] vertices() {
		Point2D[] myvertices = new Point2D[4];
		myvertices[0] = p1;
		myvertices[1] = new Point2D(p1.getX() + longueur, p1.getY());
		myvertices[2] = new Point2D(p1.getX() + longueur, p1.getY() + hauteur);
		myvertices[3] = new Point2D(p1.getX(), p1.getY() + hauteur);
		return myvertices;
	}
}
