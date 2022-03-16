package collections.problem;

public class HW {
    public static void main(String[] args) {
        String s = " Mama myla ramu";
        int wordBeg = 0;

        for (;;) {
            int space = s.indexOf(' ', wordBeg);
            int wordEnd;
            if(space != -1) {
                wordEnd = space;
            } else {
                wordEnd = s.length();
            }
            System.out.println("x"+s.substring(wordBeg,wordEnd));
            wordBeg = space+1;
            if(space == -1) {
                break;
            }
        }
       // System.out.println(i);
    }
}

// пробел в начале, в конце, несколько пробелов -- обработать.