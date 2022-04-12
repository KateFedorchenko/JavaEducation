package generics;

import java.util.NoSuchElementException;

public class Optional<T> {
    private T val;

    public Optional(T val) {
        this.val = val;
    }

    public T get(){
        if(val == null) {
            throw new NoSuchElementException();
        }
        return val;
    }

    public boolean isEmpty(){       // secure method -- no exceptions
        return val == null;
    }
}
