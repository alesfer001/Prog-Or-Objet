public class TestShape2D {
    public static void main(String[] args) {

        Point2D  p1 = new Point2D(1, 2);
        /*
        p1.print();
        p1.translate(5);
        p1.print();

        Circle c1 = new Circle(p1, 2);
        c1.print();
        c1.translate(-5);
        c1.print();
        System.out.println("Area: " + c1.area() + ", perimeter: " + c1.perimeter());

        AxesAlignedRectangle r1 = new AxesAlignedRectangle(5,2);
        r1.print();
        System.out.println("Area: " + r1.area() + ", perimeter: " + r1.perimeter());

        AxesAlignedSquare s1 = new AxesAlignedSquare(4);
        s1.print();
        System.out.println("Area: " + s1.area() + ", perimeter: " + s1.perimeter());
        */
        Point2D A = new Point2D(0, 0);
        Point2D B = new Point2D(5, 0);
        Point2D C = new Point2D(0, 5);
        /*
        Triangle t1 = new Triangle(A, B, C);
        t1.print();
        System.out.println("Area: " + t1.area() + ", perimeter: " + t1.perimeter());

        Shape2D s = new Point2D(1, 2);
        s.print();

        s = new Triangle(A, B, C);
        s.print();
        */
        Shape2D[] shapeArray = new Shape2D[5];
        shapeArray[0] = new Point2D(1, 2);
        shapeArray[1] = new Circle(p1, 2);
        shapeArray[2] = new AxesAlignedRectangle(p1, 5, 2);
        shapeArray[3] = new AxesAlignedSquare(p1, 4);
        shapeArray[4] = new Triangle(A, B, C);
        for(int i=0; i<5; i++){
          System.out.println(shapeArray[i]);
        }

        Point2D p2 = new Point2D(5, 0);
        System.out.println("Le premier point est " + p1 + " et le deuxieme " + p2);

    }
}
