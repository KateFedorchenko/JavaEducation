package multithreading.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultithreadingWordStatistics {
    public static void main(String[] args) throws Exception {
        String text = "dura Lex LEX ad sed lex ad infinum per aspera ad astra";
        Map<String, Integer> map = getWordStatisticsMT(text, 2);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

    /**
     * Counts how many unique words (case-insensitive) are contained in provided text.
     *
     * @param text        Any text which includes next set of symbols [a-zA-Z ].
     * @param threadCount Count of threads.
     * @return Map with key - unique word (lower case), value - occurence number in text.
     * <p>
     * Example: dura lex sed lex ad infinum per aspera ad astra
     * Result: {"ad": 2, "infinum":1, "per":1, "dura":1, "lex":2, "sed":1,"aspera":1, "astra":1}
     */
    public static Map<String, Integer> getWordStatisticsMT(String text, int threadCount) throws Exception {
        Map<String,Integer> map = new HashMap<>();
        String[] arr = text.toLowerCase().split(" ");
        Object mutex = new Object();
        List<Thread> threads = new ArrayList<>();

        for (int x = 0; x < threadCount; x++) {
            int batchSize = arr.length / threadCount;
            int start = batchSize * x;
            int end = (x == threadCount - 1) ? arr.length : start + batchSize;

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    for (int i = start; i < end; i++) {

                        synchronized (mutex){
                            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
                        }
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
            threads.add(t);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return map;
    }

    public static Map<String, Integer> getWordStatistics(String text){
        Map<String,Integer> map = new HashMap<>();
        String[] arr = text.toLowerCase().split(" ");

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        return map;
    }

}


// List list... --> list == null || list.isEmpty() ???? Difference
