class Cercle {
	private Point2D centre;
	private double rayon;

	public Cercle (Point2D centre, double rayon) {
		this.centre = centre;
		this.rayon = rayon;
	}

	public double surface() {
		return Math.PI * rayon*rayon;
	}

	public boolean estInterieur(Point2D p) {
		double distance = p.distance(centre);
		return distance <= rayon;
	}

	public Point2D getCentre() {
		return centre;
	}

	public void setCentre(Point2D centre) {
		this.centre = centre;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public double perimeter(){
		return 2 * Math.PI * rayon;
	}

	public void translate(double dx, double dy){
		this.centre.translate(dx, dy);
	}

	public void translate(double delta){
		this.centre.translate(delta);
	}
}