package collections.problem;

import java.util.*;

public class TextAnalysis {
    // temp function for algo testing
    public static void main(String[] args) {
        String s = "mama Mama mama myla ramu";
        analyzeText(s);

       // System.out.println(i);
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
            AnalysisResult result = (AnalysisResult)o;
            return totalWords == result.totalWords && uniqueWords == result.uniqueWords && uniqueWordsCaseInsensitive == result.uniqueWordsCaseInsensitive;
        }

        @Override public int hashCode() {
            return Objects.hash(totalWords, uniqueWords, uniqueWordsCaseInsensitive);
        }

        /*public static (String s){
            int wordBeg = 0;

            for (;;) {
                int space = s.indexOf(' ', wordBeg);
                int wordEnd;
                if(space != -1) {
                    wordEnd = space;
                } else {
                    wordEnd = s.length();
                }
                System.out.println(s.substring(wordBeg,wordEnd));
                wordBeg = space+1;
                if(space == -1) {
                    break;
                }
            }
        }*/
    }

    public static AnalysisResult analyzeText(String text) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.removeAll(Arrays.asList(""));
        Set<String> hashSet = new LinkedHashSet(list);
        ArrayList<String> removedDuplicates = new ArrayList(hashSet);

        long totalWords = list.size();
        long uniqueWords = removedDuplicates.size();
        long uniqueWordsCaseInsensitive = countUniqueWordsCaseInsensitive(text);
        return new AnalysisResult(totalWords,uniqueWords,uniqueWordsCaseInsensitive);
    }

    public static long countUniqueWordsCaseInsensitive(String text){
        String textLowCase = text.toLowerCase();
        String[] wordsLowCase = textLowCase.split(" ");
        List<String> list2 = new ArrayList<>(Arrays.asList(wordsLowCase));
        list2.removeAll(Arrays.asList(""));
        Set<String> hashSet2 = new LinkedHashSet(list2);
        ArrayList<String> removedDuplicatesCaseInsensitive= new ArrayList(hashSet2);
        return removedDuplicatesCaseInsensitive.size();
    }
}


// 1) Анализ текста программа. Ф-ия принимает одну строку. кот-ая содержит текст. Текст - набор из слов и пробелов. Слово - строка из больших и мал латинских букв и цифр.
// Нужно вывести в консоль суммарное кол-во слов и суммарное кол-во уникальных слов и кол-во уникальных слов без учета регистра. Есть тесты на задачу.
// пробел в начале, в конце, несколько пробелов -- обработать.