class Triangle {
  Point a,b,c;

  public Triangle(Point a, Point b, Point c){
    this.a = a;
    this.b = b;
    this.c = c;
  }

  double perimetre(){
    return a.distance(b)+b.distance(c)+c.distance(a);
  }

  boolean estIsocele(){
    return a.distance(b) == b.distance(c) || b.distance(c) == c.distance(a) || c.distance(a) == a.distance(b);
  }
}
