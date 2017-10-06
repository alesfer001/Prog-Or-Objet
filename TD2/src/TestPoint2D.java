class TestPoint2D {

	public static void main(String[] args) {
		Point2D p1, p2;

		p1 = new Point2D(0, 0);
		p1.print();

		p2 = new Point2D(0, 3);
		p2.print();

		System.out.println("Distance = " + p2.distance(p1));

		p1.translate(1,1);
		p1.print();

		p2.translate(1);
		p2.print();

		System.out.println("Distance = " + p2.distance(p1));

	}

}