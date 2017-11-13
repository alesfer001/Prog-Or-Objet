public class Point2D extends Shape2D {
    private double x, y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D p){
        this(p.x, p.y);
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

    public void print() {
        System.out.println(this);
    }

    public double distance(Point2D p){
        double d1 = p.x - x;
        double d2 = p.y - y;
        return Math.sqrt(d1*d1 + d2*d2);
   }
    
    public boolean inside(Point2D p){
    	return p.x == x && p.y == y; 
    }

   public String toString() {
    return "Point2D (" + x + ", "  + y + ")";
  }

}
