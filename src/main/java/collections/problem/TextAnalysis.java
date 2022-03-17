package collections.problem;

import java.util.Objects;

public class TextAnalysis {
    // temp function for algo testing
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
    }

    public static AnalysisResult analyzeText(String text) {
        // write your solution here
        return null;
    }
}

// пробел в начале, в конце, несколько пробелов -- обработать.