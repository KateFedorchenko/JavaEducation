package generics;

import beginner.LinkedListTraining;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ForwardListHW {
    public static void main(String[] args) {
//        ForwardList<String> list = new ForwardList<>();
//        list.push("bar");
//        list.push("car");
//        list.push("tap");
//        System.out.println(list.front());
//        System.out.println(list.size());
//        System.out.println(list.toString());
//        list.removeFront();
//        System.out.println(list.toString());
//
//        ForwardList<Integer> ints = new ForwardList<>();
//        ints.push(1);
//
//        for (String x : list){
//            System.out.println(x);
//        }

        List<String> it = new ArrayList<>();
        it.add("car");
        it.add("cap");
        it.add("sap");
        it.add("rap");
        ForwardList<String> list = new ForwardList<>();
        list.addAll(it);
        System.out.println(list.toString());


        System.out.println(list.getAllList());      // convert to ArrayList
    }
}
