/**
 * Geometric triangle.
 */
public class Triangle {
    public double rightSide;
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
        double height = 2 * sumOfSides / baseSide;
        double area = height * baseSide * 0.5;
        return area;
    }

    /**
     * Perimeter of triangle.
     *
     * @return Perimeter of triangle.
     */
    public double perimeter() {
        double sumOfSides = rightSide + leftSide + baseSide;
        return sumOfSides;
    }

    /**
     * True if triangle equilateral.
     */
    public boolean isEquilateral() {
        boolean result = (rightSide == leftSide && leftSide == baseSide) ? true : false;
        return result;
    }

    /**
     * True if triangle is right.
     */
    public boolean isRight() {
        double x = Math.pow(rightSide, 2);
        double y = Math.pow(leftSide, 2);
        double z = Math.pow(baseSide, 2);

        boolean result_isRight = (x+y == z || x+z == y || y+z == x) ? true : false;
        return result_isRight;
    }
}

