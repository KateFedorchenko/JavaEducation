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
        List<String> allWords = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(words[i].length() != 0) {
                allWords.add(words[i]);
            }
        }
        Set<String> uniqueWords = new HashSet<>(allWords);
        Set<String> uniqueWordsCaseInsensitive = new HashSet<>();
        for (String s : uniqueWords) {
            uniqueWordsCaseInsensitive.add(s.toLowerCase());
        }
        long totalWordCount = allWords.size();
        long uniqueWordCount = uniqueWords.size();
        long uniqueWordCountCaseInsensitive = uniqueWordsCaseInsensitive.size();
        return new AnalysisResult(totalWordCount,uniqueWordCount,uniqueWordCountCaseInsensitive);
    }


}


// 1) Анализ текста программа. Ф-ия принимает одну строку. кот-ая содержит текст. Текст - набор из слов и пробелов. Слово - строка из больших и мал латинских букв и цифр.
// Нужно вывести в консоль суммарное кол-во слов и суммарное кол-во уникальных слов и кол-во уникальных слов без учета регистра. Есть тесты на задачу.
// пробел в начале, в конце, несколько пробелов -- обработать.