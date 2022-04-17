package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * PECS - producer extends consumer super.
 */
public class PECSProblemDemo {
    public static void main(String[] args) {
        {
            List<Integer> ints = new ArrayList<>();

            ints.add(1);
            //ints.add(1.0); //CE
        }

        {
            List<Number> nums = new ArrayList<>();
            nums.add(1);
            nums.add(1.0);
            //Integer num = (Integer)nums.get(1);
        }

        if (false){
            Integer[] ints = new Integer[10];
            Number[] nums = ints;//Heap pollution possible

            /*Integer*/nums[0] = Double.valueOf(1.0);

            Number n = Double.valueOf(1.0);

            Integer x = ints[0];

            //Integer x = Double.valueOf(1.0);
        }

        {
            List<Integer> ints = new ArrayList<>(List.of(1,2,3,4,5));
            //List<Number> nums = ints; //why CE?
            List<? extends Number> nums = ints;
            Number number = nums.get(1);
        }

        {
            List<Number> nums = new ArrayList<>();
            nums.add(Double.valueOf(10.0));
            nums.add(Integer.valueOf(42));
            nums.add(Integer.valueOf(0));

            List<? super Integer> ints = nums;
            ints.add(Integer.valueOf(33));
        }

        {
            List<Number> numbers = new ArrayList<>();
            List<Integer> ints = List.of(1,2,3);
            numbers.addAll(ints);
        }

        {
            MyList<Number> nums = new MyList<>();
            MyList<Integer> ints = new MyList<>(/*some data*/);

            nums.addAll(ints);
        }

        {
            List<Integer> ints = new ArrayList<>(List.of(1,2,3));
            //List<Object> != List
            List rawList = ints;

            rawList.add("foo");//idx = 3

            Integer x = ints.get(3);
        }
    }

    public static class MyList<E> {
        void addAll(MyList<? extends E> otherList) {
            for (int i = 0; i < 10; ++i) {
                E otherElement = otherList.get(i);
            }
        }

        E get(int idx) {
            return null;
        }
    }
}
