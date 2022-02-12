package beginner;

import java.util.Calendar;

public class Class2 {
    public static void main(String[] args) {
        Snowflake snowflake = new Snowflake(0.1,"plate");
        double size = snowflake.getSize();
        snowflake.getForm();
        Calendar date = snowflake.getDate();
        date.set(Calendar.MONTH, 11);
        System.out.println();


    }

}
