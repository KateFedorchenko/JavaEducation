package multithreading.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultithreadingWordStatistics {
    public static void main(String[] args) throws Exception {
        String text = "dura Lex sed lex ad infinum per aspera ad astra";
        Map<String, Integer> map = getWordStatisticsMT(text,2);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

    /**
     * Counts how many unique words (case-insensitive) are contained in provided text.
     * @param text Any text which includes next set of symbols [a-zA-Z ].
//     * @param threadCount Count of threads.
     * @return Map with key - unique word (lower case), value - occurence number in text.
     *
     * Example: dura lex sed lex ad infinum per aspera ad astra
     * Result: {"ad": 2, "infinum":1, "per":1, "dura":1, "lex":2, "sed":1,"aspera":1, "astra":1}
     */
    public static Map<String, Integer> getWordStatisticsMT(String text, int threadCount) throws Exception{
        String[] arrOfStrings = text.toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap();
        if(text == null || arrOfStrings.length == 1){
            System.out.println("The input is null or contains no more than one single word");
            return null;
        }
        List<HashMap<String,Integer>> list = new ArrayList<>();
        Object mutex = new Object();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            Runnable r = new Runnable(){
                @Override public void run() {
                    int count = 1;
                    for (int i = 0; i < arrOfStrings.length; i++) {
                        if(map.containsKey(arrOfStrings[i])){
                            i++;
                        }
                        for (int j = i + 1; j < arrOfStrings.length; j++) {
                            if(arrOfStrings[i].equals(arrOfStrings[j])) {
                                map.put(arrOfStrings[i],count+=1);
                            }
                        }
                        if(!map.containsKey(arrOfStrings[i])) {
                            map.put(arrOfStrings[i],1);
                        }
                        count = 1;

                        synchronized (mutex) {
//                          list.add(map.get(i));     // TODO
                            list.get(i);
                        }
                    }
                }
            };
            Thread t = new Thread();
            t.start();
            threads.add(t);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return map;
    }
}
