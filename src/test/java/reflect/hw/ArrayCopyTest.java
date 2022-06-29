package reflect.hw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCopyTest {
    static class Data {
        int x = 42;

        public Data(int x) {
            this.x = x;
        }

        /**
         * Contains deep-copy logic.
         */
        Data copy() {
            return new Data(x);
        }
    }
    @Test
    void test() {
        Data[] arr1 = new Data[]{new Data(42), new Data(111)};
        Data[] arr2 = new Data[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }

        arr1[0].x = 43;

        assert arr2[0].x == 43;
    }

}