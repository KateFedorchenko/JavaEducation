package collections;

import java.util.Arrays;

public class SimpleDynamicArrayDemo {
    public static void main(String[] args) {
        SimpleIntDynamicArray array = new SimpleIntDynamicArray();
        // System.out.println(Arrays.toString(array));  // почему в консоли выводит collections.SimpleIntDynamicArray@eed1f14 ??
        for (int i = 0; i < 6; i++) {
            array.add(i);
        }
        //System.out.println(array.get(2)); // output 3
        //array.set(0,34);
       // System.out.println(array.size());
        array.remove(1);
        System.out.println(array.get(1));


    }
}

/* Вопросы:
1) Хочу вывести в консоль массив. Передаю в методе toString() экземпляр класса. Выводит collections.SimpleIntDynamicArray@eed1f14.
*/

// реализовать остальные методы. Нет никаких доп полей. Только если посчитаю что-то полезным -  к осбуэдению.
// проблема с методом удаления - с коцна все ок. но с середины будет дырка. которую надо заделать.