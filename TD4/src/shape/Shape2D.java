package shape;
public abstract class Shape2D {

	protected String name;
	protected int r,g,b;
	protected int zIndex;

	public abstract double area();

	public abstract double perimeter();

	public abstract void translate(double dx, double dy);

	public abstract void translate(double delta);

	public abstract void print();
}
