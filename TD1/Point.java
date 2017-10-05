class Point {
  public double x,y;
  public void afficher(){
    System.out.println("(" + x + "," + y + ")");
  }

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  // Deplace un point par rapport à sa position d'origine
  void deplacement(double dx, double dy){
    x+=dx;
    y+=dy;
  }
  void deplacement(double delta){
    x+=delta;
    y+=delta;
  } // meme deplacement en x et en y

  // Calcul la distance entre deux points
  double distance(Point p){
    return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
  }
}
