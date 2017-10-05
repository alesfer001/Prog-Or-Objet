class TestPoint {
  public static void main(String[] args){
    Point mypoint = new Point(1,2);
    mypoint.afficher();
    mypoint.deplacement(1,2);
    mypoint.afficher();
    mypoint.deplacement(1);
    mypoint.afficher();
    System.out.println("Distance to : " + mypoint.distance(new Point(3,5)));
  }
}
