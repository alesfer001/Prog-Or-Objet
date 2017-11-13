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
  
  boolean inside(Point2D p){
	  return centre.distance(p) < rayon;
  }
  
  boolean inside(Polygone p){
	  Point2D[] pointArray = new Point2D[4];
	  pointArray = p.vertices();
	  for(int i=0; i<5; i++){
		  if(!this.inside(pointArray[i])){
			  return false;
		  }
	  }
	  return true;
  }
  
  boolean inside(Circle c){
	  return centre.distance(c.getCentre()) <= rayon - c.getRayon(); 
  }
  
  public String svg(){
		return "<circle cx='" + centre.getX() + "' cy='"+ centre.getY() + "' r='" + rayon + "' fill='rgb(" + r + "," + g + "," + b + ")' />";
	}

  public String toString(){
    return "Circle ((" + centre.getX() + ", " + centre.getY() + "), "  + rayon + ")";
  }
}
