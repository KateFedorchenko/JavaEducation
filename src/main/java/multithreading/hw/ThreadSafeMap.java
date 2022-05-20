package multithreading.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThreadSafeMap{
    int key;
    String value;


    public ThreadSafeMap(int key, String value){
        this.key = key;
        this.value = value;
    }


//     put(){
//
//    }
//
//    get(){
//
//    }
//
//    size(){
//
//    }
//
//    replace(){
//
//    }

    public static void main(String[] args) {
        ThreadSafeMap element1 = new ThreadSafeMap(1,"boo");
        List<ThreadSafeMap> list = new ArrayList<>();
        list.add(element1);
        list.size();



    }
}
