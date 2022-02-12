package beginner;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class InterfacesDemo {
    public static void main(String[] args) throws Exception{
        ChristmasTree tree = new ChristmasTree(23,4);
        tree.print(System.out);
        tree.print(System.err);
        tree.print(new PrintStream(new FileOutputStream("D:\\test.txt")));
        tree.clone();
    }

    static interface Printable{

        /*public abstract*/ void print(PrintStream out);
    }

    static interface Cloneable{

        /*public abstract*/ Object clone();
    }

    static class ChristmasTree implements Printable, Cloneable{
        private int height;
        private int numOfToys;

        public ChristmasTree(int height, int numOfToys) {
            this.height = height;
            this.numOfToys = numOfToys;
        }

        @Override
        public void print(PrintStream out) {
            out.println("Christmas Tree with height "+height+" and number of toys "+numOfToys);
        }

        @Override
        public Object clone() {
            return new ChristmasTree(height,numOfToys);
        }
    }
}
