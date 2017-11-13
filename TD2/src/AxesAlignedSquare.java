public class AxesAlignedSquare extends AxesAlignedRectangle {

  public AxesAlignedSquare(Point2D p1, double cote){
    super(p1, cote, cote);
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
    return "AxesAlignedSquare ((" + this.getOrigin().getX() + ", " + this.getOrigin().getY() + "), " + this.getLongueur() + ")";
  }
}
