/**
 * Geometric triangle.
 */
public class Triangle {
    public double rightSide; // all fields must be private
    public double leftSide;
    public double baseSide;

    public Triangle (double rightSide, double leftSide, double baseSide) {
        this.rightSide = rightSide;
        this.leftSide = leftSide;
        this.baseSide = baseSide;
    }

    /**
     * Area of triangle.
     *
     * @return Area of triangle.
     */
    public double area() {
        double sumOfSides = rightSide + leftSide + baseSide; // can the method perimeter() be called here?
        double height = 2 * sumOfSides / baseSide; // error - to be
        double area = height * baseSide * 0.5;
        return area;
    }

    /**
     * Perimeter of triangle.
     *
     * @return Perimeter of triangle.
     */
    public double perimeter() {
        return rightSide + leftSide + baseSide;
    }

    /**
     * True if triangle equilateral.
     */
    public boolean isEquilateral() {
        return (rightSide == leftSide && leftSide == baseSide);
    }

    /**
     * True if triangle is right.
     */
    public boolean isRight() {
        double x = Math.pow(rightSide, 2);
        double y = Math.pow(leftSide, 2);
        double z = Math.pow(baseSide, 2);

        // _ - is not ok
        return (x+y == z || x+z == y || y+z == x);
    }
}

