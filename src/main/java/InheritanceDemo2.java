public class InheritanceDemo2{
    public static void main(String[] args) {
        Figure[] arr = new Figure[5];
        arr[0] = new Triangle(2,2,2);
        arr[1] = new Rectangle(2,2);
        arr[2] = new Square(2);
        arr[3] = new Circle(2);
        arr[4] = new Triangle(3,4,4);


    }

    public static double sumOfAreas(Figure[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].area();
        }
        return sum;
    }


    static abstract class Figure{

        public abstract double area();
        public abstract double perimeter();

    }

    static class Point extends Figure{
        @Override
        public double area() {
            return 0;
        }

        @Override
        public double perimeter() {
            return 0;
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



        public Circle(double radius){
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.pow(radius,2) * Math.PI;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI *radius;
        }


    }

}
