import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InterfaceTask1 {

    private static final String LOG_FILE_NAME = "D:\\\\logs.txt";
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log log = new Log("\"logType:StoredFunctionExec\", \"params\":\"GAMEID\":\"1000\"","f23hjbj3", df.format(new Date()));
        log.print();

    }

    static interface PrintLog{
        boolean print();           // no body because it is abstract.
    }

    static class Log implements PrintLog{
        private String message;
        private String traceId;
        private String c;

        public Log(String message, String traceId, String c){
            this.message =message;
            this.traceId = traceId;
            this.c = c;
        }

        @Override
        public boolean print() {
            try {
                FileWriter fw = new FileWriter(LOG_FILE_NAME,true);
                fw.write(message + "\t"+traceId+"\t"+c+"\n");
                fw.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }




}
