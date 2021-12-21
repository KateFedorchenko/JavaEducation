public class InheritanceDemo2{
    public static void main(String[] args) {
        Triangle triangle = new Triangle(12.5,12.5,16);
        triangle.perimeter();
        triangle.area();

        Rectangle rectangle = new Rectangle(25.5, 35.5);
        rectangle.perimeter();
        rectangle.area();

        Square square = new Square(25.5);
        square.perimeter();
        square.area();

        Circle сircle = new Circle(6.5);
        сircle.perimeter();
        сircle.area();

    }


    static class Figure{
        private double rightSide;
        private double leftSide;
        private double baseSide;

        public Figure(double rightSide,double leftSide,double baseSide) {
            this.rightSide = rightSide;
            this.leftSide = leftSide;
            this.baseSide = baseSide;
        }

        public double area(){
            return 1;
        }

        public double perimeter(){
            return 1;
        }

        public double getRightSide() {
            return rightSide;
        }
        public double getLeftSide() {
            return leftSide;
        }
        public double getBaseSide() {
            return baseSide;
        }
    }


    static class Triangle extends Figure{

        public Triangle(double rightSide, double leftSide, double baseSide){
            super(rightSide);
            super(leftSide);
            super(baseSide);
        }

        @Override
        public double area() {
            double p = 0.5 * perimeter();
            return Math.sqrt(p * (p - getRightSide()) * (p - getLeftSide()) * (p - getBaseSide()));
        }

        @Override
        public double perimeter() {
            return getRightSide() + getLeftSide() + getBaseSide();
        }

    }

    static class Rectangle extends Figure{


        public Rectangle(double rightSide, double baseSide){
            super(rightSide);
            super(baseSide);
        }

        @Override
        public double area() {
            return getRightSide() * getBaseSide();
        }

        @Override
        public double perimeter() {
            return getRightSide() + getBaseSide() + getRightSide() + getBaseSide();
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
