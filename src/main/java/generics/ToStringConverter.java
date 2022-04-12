package generics;

public class ToStringConverter<S> implements Converter<S,String> {
    @Override
    public String convert(S source){
        return source.toString();
    }

}
