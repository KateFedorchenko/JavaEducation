package generics;

public interface Converter<S,R> {                               //S - source; R - result
    R convert(S source);
}

