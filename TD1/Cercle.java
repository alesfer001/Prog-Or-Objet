class Cercle {
  double rayon;
  Point centre;

  public Cercle(Point centre, double rayon){
    this.centre = centre;
    this.rayon = rayon;
  }

  double surface(){
    return Math.PI * rayon * rayon;
  } // retourne la surface du cercle (pi fois le carré du rayon)
  boolean estInterieur(Point p){
    return centre.distance(p) <= rayon;
  } // teste si le point p passé en paramètre fait ou non partie du cercle (frontière comprise : disque fermé). La méthode retournera `true` si le test est positif, et `false` dans le cas contraire.
}
