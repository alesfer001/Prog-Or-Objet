package test;


import shape.Point2D.Point2D;
//import shape.Polygon.AxesAlignedRectangle;

public class TestShape2D {
	public static void main(String[] args) {
		//AxesAlignedRectangle myrec = new AxesAlignedRectangle("name", new Point2D("anothername", 0, 0), 5, 10);
		Point2D D = new Point2D("A",1.0, 1.0);
		Point2D E = new Point2D("A",1.0, 1.0);
		if (D.equals(E)) {
			System.out.println("Les points sont égaux");
		}
		else {
			System.out.println("Les points ne sont pas égaux");
		}

	}
}
