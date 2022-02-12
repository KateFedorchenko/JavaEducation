package beginner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class InterfaceTask2 {
   // private static final String STUDENTS_LIST_NAME = "D:\\\\students_list.txt";
    public static void main(String[] args) throws Exception {
        Students student1 = new Students("Tom", "Hanks", 18, "AB12");
        Students student2 = new Students("John", "Smith", 17, "AB14");
        Students student3 = new Students("Sarah", "Bool", 20, "AB12");
        Students student4 = new Students("Bob", "Swovsky", 17, "AB14");
        Students student5 = new Students("Kate", "LeBlanc", 18, "AB12");
        printAllStudents(new Students[]{student1, student2, student3, student4, student5});
        sendAllStudents(new Students[]{student1, student2, student3, student4, student5});
    }
       public static void printAllStudents(Print[] printables) {
            for (int i = 0; i < printables.length; i++) {
                printables[i].printStudents();
            }
        }

        public static void sendAllStudents(Send[] printables) throws Exception {
            PrintStream ps = new PrintStream(new FileOutputStream("D:\\students_list.txt"));
            for (int i = 0; i < printables.length; i++) {
                printables[i].sendList(ps);
             }
        }

    static interface Print {
        void printStudents();
    }

    static interface Send {
        void sendList(PrintStream out);
    }

    static class Students implements Print, Send {
        private String name;
        private String surname;
        private int age;
        private String group;

        public Students(String name, String surname, int age, String group) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.group = group;
        }


        @Override
        public void printStudents() {
                System.out.println(name+" "+surname+" "+age+" "+group+"\n");
            }


        @Override
        public void sendList(PrintStream out){
            out.println(name+" "+surname+" "+age+" "+group+"\n");
    }

}
}


