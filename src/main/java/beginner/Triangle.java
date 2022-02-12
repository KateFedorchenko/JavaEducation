package beginner;

/**
 * Geometric triangle.
 */
public class Triangle {
    private double rightSide;
    private double leftSide;
    private double baseSide;

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
        double p = 0.5 * perimeter();
        return Math.sqrt(p * (p - rightSide) * (p - leftSide) * (p - baseSide));
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
        return (x+y == z || x+z == y || y+z == x);
    }
}

