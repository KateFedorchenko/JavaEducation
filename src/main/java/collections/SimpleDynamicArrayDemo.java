package collections;

public class SimpleDynamicArrayDemo {
    public static void main(String[] args) {
        SimpleIntDynamicArray array = new SimpleIntDynamicArray();
        for (int i = 0; i < 1000000; i++) {
            array.add(i);
        }

        System.out.println(array.get(2)); // output 3


    }
}


// реализовать остальные методы. Нет никаких доп полей. Только если посчитаю что-то полезным -  к осбуэдению.
// проблема с методом удаления - с коцна все ок. но с середины будет дырка. которую надо заделать.