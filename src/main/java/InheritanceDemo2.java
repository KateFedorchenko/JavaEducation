public class InheritanceDemo2{
    public static void main(String[] args) {
        Triangle triangle = new Triangle(12.5,12.5,16);
        System.out.println("triangle.perimeter() = " + triangle.perimeter());
        System.out.println("triangle.area() = " + triangle.area());

        Rectangle rectangle = new Rectangle(25.5, 35.5);
        System.out.println("rectangle.perimeter() = " + rectangle.perimeter());
        System.out.println("rectangle.area() = " + rectangle.area());

        Square square = new Square(25.5);
        System.out.println("square.perimeter() = " + square.perimeter());
        System.out.println("square.area() = " + square.area());

        Circle сircle = new Circle(6.5);
        System.out.println("сircle.perimeter() = " + сircle.perimeter());
        System.out.println("сircle.area() = " + сircle.area());

    }


    static class Figure{

        public double area(){
            return 1;
        }

        public double perimeter(){
            return 1;
        }

    }


    static class Triangle extends Figure{
        private double rightSide;
        private double leftSide;
        private double baseSide;

        public Triangle(double rightSide, double leftSide, double baseSide){
           this.rightSide = rightSide;
           this.leftSide = leftSide;
           this.baseSide = baseSide;
        }

        @Override
        public double area() {
            double p = 0.5 * perimeter();
            return Math.sqrt(p * (p - rightSide) * (p - leftSide) * (p - baseSide));
        }

        @Override
        public double perimeter() {
            return rightSide + leftSide + baseSide;
        }

    }

    static class Rectangle extends Figure{
        private double rightSide;
        private double baseSide;


        public Rectangle(double rightSide, double baseSide){
            this.rightSide = rightSide;
            this.baseSide = baseSide;
        }

        @Override
        public double area() {
            return rightSide * baseSide;
        }

        @Override
        public double perimeter() {
            return rightSide + baseSide + rightSide + baseSide;
        }

    }

    static class Square extends Figure{
        private double side;

        public Square(double side){
            this.side = side;
        }

        @Override
        public double area() {
            return side * side;
        }

        @Override
        public double perimeter() {
            return 4*side;
        }

        public double getSide() {
            return side;
        }
    }



    static class Circle extends Figure{
        private double radius;
        private final double P = 3.14;

        public Circle(double radius){
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.pow(radius,2) * P;
        }

        @Override
        public double perimeter() {
            return 2 * P *radius;
        }


        public double getRadius() {
            return radius;
        }
        public double getP() {
            return P;
        }
    }

}
