import java.util.Scanner;

class Geometrie {
  public static Scanner clavier = new Scanner(System.in);

  public static void main(String[] args){
    Point[] tab = new Point[3];
    double x,y;
    for(int i=0; i<3; i++){
      System.out.println("Construction d'un nouveau point");
      System.out.print("Veuillez entrer x : ");
      x = clavier.nextDouble();
      System.out.print("Veuillez entrer y : ");
      y = clavier.nextDouble();
      tab[i] = new Point(x,y);
    }
    Triangle mytriangle = new Triangle(tab[0], tab[1], tab[2]);
    System.out.println("Perimètre : " + mytriangle.perimetre());
    System.out.println("Triangle Isocèle : " + mytriangle.estIsocele());
  }
}
