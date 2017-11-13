import java.io.FileWriter;
import java.io.IOException;

public class MonMain {
	public static void main(String[] args) throws IOException {
		Point2D  centre = new Point2D(200,200);
		Point2D  A = new Point2D(200, 10);
		Point2D  B = new Point2D(250, 190);
		Point2D  C = new Point2D(160, 210);
		Cercle c = new Cercle(new Point2D(centre.getX(), centre.getY()), 50);
		AxesAlignedRectangle r = new AxesAlignedRectangle(centre, 400, 100);
		AxesAlignedSquare s = new AxesAlignedSquare(centre, 200);
		Triangle t = new Triangle(A, B, C);
		
		c.setColor(255, 0, 0);
		r.setColor(0, 255, 0);
		s.setColor(0, 0, 255);
		t.setColor(100, 100, 100);
		
		FileWriter out = new FileWriter("test.svg");
		out.write("<?xml version='1.0' encoding='utf-8'?>\n");
		out.write("<svg xmlns='http://www.w3.org/2000/svg' version='1.1' width='800' height='600'>");
		out.write(c.svg());
		out.write(r.svg());
		out.write(s.svg());
		out.write(t.svg());
		out.write("</svg>");
		out.close();
	}
}