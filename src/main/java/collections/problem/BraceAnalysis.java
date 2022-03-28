package collections.problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class BraceAnalysis {
    public static void main(String[] args) {
        String str = "({}[ab]2f{})";
        System.out.println(isCorrectModification2(str));


//        String str = "(())";
//        System.out.println(isCorrect(str));
//        String str2 = "(()(()))";
//        System.out.println(isCorrect(str2));
//        String str3 = "())";
//        System.out.println(isCorrect(str3));
//        String str4 = ")";
//        System.out.println(isCorrect(str4));

//        System.out.println(isCorrectModification1(str));
//        String str2 = "({}{}{}[])";
//        System.out.println(isCorrectModification1(str2));
//        String str3 = "({}{}{}[])[)";
//        System.out.println(isCorrectModification1(str3));
    }

    /**
     * The function analyzes str which contains of "(" and ")" and returns the result true if sequence is correct.
     * For example, "(())" is correct, "(" is wrong, "(()(()))" is correct.
     */
    public static boolean isCorrect(String str){
        char[] arr = str.toCharArray();     // 1 var
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '('){
                stack.push(arr[i]);
            }
            if(arr[i] == ')'){
                if(stack.isEmpty()){      // not just to avoid Exception but also to check whether the stack is empty or not
                    return false;
                }
                char poppedChar = stack.pop();
                if(poppedChar != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * The function analyzes str which contains three types of braces (),[],{} and returns the result true if sequence is correct.
     * For example, "(())" is correct, "(" is wrong, "(()(()))" is correct.
     */
    public static boolean isCorrectModification1(String str){
        char[] arr = str.toCharArray();
        Deque<Character> stackForParentheses = new ArrayDeque<>();
        Deque<Character> stackForCurlyBraces = new ArrayDeque<>();
        Deque<Character> stackForSquareBraces = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '('){

                stackForParentheses.push(arr[i]);
            }
            if(arr[i] == '{'){
                stackForCurlyBraces.push(arr[i]);
            }
            if(arr[i] == '['){
                stackForSquareBraces.push(arr[i]);
            }


            if(arr[i] == ')'){
                if(stackForParentheses.isEmpty()){
                    return false;
                }
                char poppedChar = stackForParentheses.pop();
                if(poppedChar != '('){
                    return false;
                }
            }
            if(arr[i] == '}'){
                if(stackForCurlyBraces.isEmpty()){
                    return false;
                }
                char poppedChar = stackForCurlyBraces.pop();
                if(poppedChar != '{'){
                    return false;
                }
            }
            if(arr[i] == ']'){
                if(stackForSquareBraces.isEmpty()){
                    return false;
                }
                char poppedChar = stackForSquareBraces.pop();
                if(poppedChar != '['){
                    return false;
                }
            }
        }
        return stackForParentheses.isEmpty() && stackForCurlyBraces.isEmpty() && stackForSquareBraces.isEmpty();
    }

    public static boolean isCorrectModification2(String str){
        char[] arr = str.toCharArray();
        Deque<Character> stackForParentheses = new ArrayDeque<>();
        Deque<Character> stackForCurlyBraces = new ArrayDeque<>();
        Deque<Character> stackForSquareBraces = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '('){

                stackForParentheses.push(arr[i]);
            }
            if(arr[i] == '{'){
                stackForCurlyBraces.push(arr[i]);
            }
            if(arr[i] == '['){
                stackForSquareBraces.push(arr[i]);
            }


            if(arr[i] == ')'){
                if(stackForParentheses.isEmpty()){
                    return false;
                }
                char poppedChar = stackForParentheses.pop();
                if(poppedChar != '('){
                    return false;
                }
            }
            if(arr[i] == '}'){
                if(stackForCurlyBraces.isEmpty()){
                    return false;
                }
                char poppedChar = stackForCurlyBraces.pop();
                if(poppedChar != '{'){
                    return false;
                }
            }
            if(arr[i] == ']'){
                if(stackForSquareBraces.isEmpty()){
                    return false;
                }
                char poppedChar = stackForSquareBraces.pop();
                if(poppedChar != '['){
                    return false;
                }
            }
        }
        return stackForParentheses.isEmpty() && stackForCurlyBraces.isEmpty() && stackForSquareBraces.isEmpty();
    }
}


// modification 1--> three types of braces (),[],{}.
// modification 2--> three types of braces (),[],{}  +  additional symbols like letters "a,sf,ef,232,5,6".
// new methods to create for all modifications.
// Stack structure -- keep in mind.