public class AxesAlignedRectangle extends Shape2D {
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

  public String toString(){
    return "AxesAlignedRectangle ((" + p1.getX() + ", " + p1.getY() + "), " + longueur + ", "  + hauteur + ")";
  }
}
