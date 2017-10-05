// Pour utiliser les bibliothèques standards
import java.util.Random;
import java.util.Scanner;

class Mystere {

	// Permet de lire ce que l'utilisateur saisi au clavier
	public static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args) {
		// Un générateur de nombre aléatoire
		Random aleatoire = new Random();
		// Génère un nombre compris entreo 0 et 100 (exclus)
		int mystere = aleatoire.nextInt(100);

    int coups = 0;
    int essai = 0;
    while(coups < 10 && essai != mystere){
      System.out.print("Nombre : ");
  		// Lit un entier au clavier, génère une erreur si la valeur saisie n'est pas un entier
  		essai = clavier.nextInt();
      if(essai < mystere){
        System.out.println("Le nombre mystère est plus grand!");
      }
      else if(essai > mystere){
        System.out.println("Le nombre mystère est plus petit");
      }
      coups++;
    }

		System.out.println("Votre nombre est " + essai + " et le nombre mystere est " + mystere);

    if(essai == mystere){
      System.out.println("Vous avez gagné en " + coups + " coups!");
    }
    else{
      System.out.println("Vous avez perdu!");
    }
	}
}
