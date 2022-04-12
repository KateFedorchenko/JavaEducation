package generics;

/**Converts from Strings with format yyyy-MONTH-dd
 * returns SimpleDate
 */
public class StringToSimpleDateConverter implements Converter<String,SimpleDate>{
    @Override
    public SimpleDate convert(String source) {
        String[] arr = source.split("-");
        if(arr.length != 3){
            throw new RuntimeException("Should be 3 elements");
        }
        int year = Integer.parseInt(arr[0]);
        Month month = Month.valueOf(arr[1].toUpperCase());
        int day = Integer.parseInt(arr[2]);
        return new SimpleDate(day,month,year);
    }
}


