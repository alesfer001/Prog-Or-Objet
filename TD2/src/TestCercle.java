class TestCercle {
	public static void main(String[] args) {
		Point2D  p = new Point2D(2,3);
		Point2D  centre = new Point2D(1,1);
		Cercle c = new Cercle(new Point2D(centre.getX(), centre.getY()), 4);
		centre.setX(12);
		System.out.println("Surface = " + c.surface());
		System.out.println("Interieur : " + c.estInterieur(p));
		System.out.println(c.getCentre()+"<->"+centre);
	}
}