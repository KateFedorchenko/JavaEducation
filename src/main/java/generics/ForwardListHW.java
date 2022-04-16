package generics;

import beginner.LinkedListTraining;

import java.util.Iterator;


public class ForwardListHW {
    public static void main(String[] args) {
        ForwardList<String> list = new ForwardList<>();
        list.push("bar");
        list.push("car");
        list.push("tap");
        System.out.println(list.front());
        System.out.println(list.size());
        System.out.println(list.toString());
        list.removeFront();
        System.out.println(list.toString());


//        ForwardList<Integer> ints = new ForwardList<>();
//        list.push(1);                                         // why 1 is not ok here?

    }
}
