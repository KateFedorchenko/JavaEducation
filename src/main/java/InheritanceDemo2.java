public class InheritanceDemo2 {
        public static void main(String[] args) {
            Triangle triangle = new Triangle("Triangle",12.5,12.5,16);
            System.out.println("triangle.perimeter() = " + triangle.perimeter());
            System.out.println("triangle.area() = " + triangle.area());

            Rectangle rectangle = new Rectangle("Rectangle",25.5, 35.5);
            System.out.println("rectangle.perimeter() = " + rectangle.perimeter());
            System.out.println("rectangle.area() = " + rectangle.area());

            Square square = new Square("Square",25.5);
            System.out.println("square.perimeter() = " + square.perimeter());
            System.out.println("square.area() = " + square.area());

        }


        static class Figure{
            String name;

            public Figure(String name){
                this.name = name;
            }
        }


        static class Triangle extends Figure{
            double rightSide;
            double leftSide;
            double baseSide;

            public Triangle(String name, double rightSide, double leftSide, double baseSide){
                super(name);
                this.rightSide = rightSide;
                this.leftSide = leftSide;
                this.baseSide = baseSide;
            }

            public double area() {
                double p = 0.5 * perimeter();
                return Math.sqrt(p * (p - rightSide) * (p - leftSide) * (p - baseSide));
            }

            public double perimeter() {
                return rightSide + leftSide + baseSide;
            }
        }

        static class Rectangle extends Figure{
            double rightSide;
            double baseSide;

            public Rectangle(String name, double rightSide, double baseSide){
                super(name);
                this.rightSide = rightSide;
                this.baseSide = baseSide;
            }

            public double area() {
                return rightSide * baseSide;
            }

            public double perimeter() {
                return rightSide + baseSide + rightSide + baseSide;
            }
        }

        static class Square extends Figure{
            double side;

            public Square(String name, double side){
                super(name);
                this.side = side;
            }

            public double area() {
                return side * side;
            }

            public double perimeter() {
                return 4*side;
            }
        }

}
