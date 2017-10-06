class Point2D {
	private double x, y;

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	Point2D() {
		// Does nothing
	}

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void print() {
		System.out.println("Point : (" + x + ", " + y + ")");
	}

	public void translate(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public void translate(double delta) {
		translate(delta, delta);
	}

	public double distance(Point2D p) {
		double d1 = p.x - x;
		double d2 = p.y - y;
		return Math.sqrt(d1*d1 + d2*d2);
	}
}