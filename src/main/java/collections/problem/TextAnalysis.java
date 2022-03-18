package collections.problem;

import java.util.*;

public class TextAnalysis {
    // temp function for algo testing
    public static void main(String[] args) {
        String s = "foo Foo fOO FOO";
        System.out.println(analyzeText(s));
        /*int wordBeg = 0;

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
       // System.out.println(i);*/
    }

    public static class AnalysisResult {
        public final long totalWords;
        public final long uniqueWords;
        public final long uniqueWordsCaseInsensitive;

        public AnalysisResult(long totalWords, long uniqueWords, long uniqueWordsCaseInsensitive) {
            this.totalWords = totalWords;
            this.uniqueWords = uniqueWords;
            this.uniqueWordsCaseInsensitive = uniqueWordsCaseInsensitive;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            AnalysisResult result = (AnalysisResult)o;         // (AnalysisResult)o   --> what
            return totalWords == result.totalWords && uniqueWords == result.uniqueWords && uniqueWordsCaseInsensitive == result.uniqueWordsCaseInsensitive;
        }

        @Override public int hashCode() {
            return Objects.hash(totalWords, uniqueWords, uniqueWordsCaseInsensitive);
        }
    }

    public static AnalysisResult analyzeText(String text) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(words));
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i).equals("")) {
                list.remove(i);                              // why some elements with the value "" are not being deleted??
            }
        }

        String[] copy = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            copy[i] = list.get(i);
        }

        long totalWords = copy.length;

        long uniqueWords = copy.length;
        for (int i = 0; i < copy.length-1; i++) {
            for (int j = i+1; j < copy.length; j++) {
                if(copy[i].equals(copy[j])) {
                    uniqueWords--;
                }
            }
        }

        long uniqueWordsCaseInsensitive = copy.length;
        for (int i = 0; i < copy.length-1; i++) {
            for (int j = i+1; j < copy.length; j++) {
                if(copy[i].equalsIgnoreCase(copy[j])) {
                    uniqueWordsCaseInsensitive--;
                }
            }
        }
        if(uniqueWordsCaseInsensitive <= 0) {
            uniqueWordsCaseInsensitive = 1;
        }

        return new AnalysisResult(totalWords,uniqueWords,uniqueWordsCaseInsensitive);
    }
}


// 1) Анализ текста программа. Ф-ия принимает одну строку. кот-ая содержит текст. Текст - набор из слов и пробелов. Слово - строка из больших и мал латинских букв и цифр.
// Нужно вывести в консоль суммарное кол-во слов и суммарное кол-во уникальных слов и кол-во уникальных слов без учета регистра. Есть тесты на задачу.
// пробел в начале, в конце, несколько пробелов -- обработать.