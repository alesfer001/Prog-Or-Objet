class TestCercle {
  public static void main(String[] args){
    Cercle mycercle = new Cercle(new Point(0,0), 2);
    System.out.println("Surface : " + mycercle.surface());
    System.out.println(mycercle.estInterieur(new Point(0,1)));
    System.out.println(mycercle.estInterieur(new Point(0,2)));
    System.out.println(mycercle.estInterieur(new Point(0,3)));
  }
}
