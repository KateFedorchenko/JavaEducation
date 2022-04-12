package generics;

public class SimpleDate {
    private int day;
    private Month month;
    private int year;


    public SimpleDate(int day, Month month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public int getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "SimpleDate{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}


enum Month{
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
}