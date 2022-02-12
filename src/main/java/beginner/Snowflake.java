package beginner;

import java.util.Calendar;

public class Snowflake {
    private double size;
    private String form;
    private Calendar date = Calendar.getInstance();

    public Snowflake(double size, String form) {
        this.size = size;
        this.form = form;
    }

    public double getSize() {
        return size;
    }

    public String getForm() {
        Snowflake x = this;
        return form;
    }

    public Calendar getDate() {                      //защитное копирование
        Calendar copy = Calendar.getInstance();
        copy.setTime(date.getTime());
        return copy;
    }


}
