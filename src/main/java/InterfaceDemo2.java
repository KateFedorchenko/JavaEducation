import java.io.FileWriter;
import java.io.IOException;

public class InterfaceDemo2 {
    private static final String TOPIC_FILE_NAME = "D:\\\\message_topic.dat";
    public static void main(String[] args) {
        Message message1 = new Message("hello","time=22.01.22","about today");
        Letter letter1 = new Letter("Tom","Max","hello");
        printAll(new Printable[] {message1,letter1});

    }

    public static void printAll(Printable[] printables) {
        for (int i = 0; i < printables.length; i++) {
            printables[i].print();
        }
    }

    static interface Printable{
        void print();
    }

    static interface Sendable {
        boolean send();
    }

    static class Message implements Printable, Sendable{
        private String topic;
        private String header;
        private String body;


        public Message(String topic, String header, String body) {
            this.topic = topic;
            this.header = header;
            this.body = body;
        }

        @Override
        public void print() {
            System.out.println(topic+header+body);
        }

        @Override
        public boolean send() {
            try {
                FileWriter fw = new FileWriter(TOPIC_FILE_NAME,true);
                fw.write(topic + "\t"+header+"\t"+body+"\n");
                fw.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
    static class Letter implements  Printable{
        private String sender;
        private String receiver;
        private String text;

        public Letter(String sender, String receiver, String text) {
            this.sender = sender;
            this.receiver = receiver;
            this.text = text;
        }

        @Override
        public void print() {
            System.out.println(sender+receiver+text);
        }
    }
}
