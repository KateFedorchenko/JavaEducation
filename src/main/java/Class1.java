public class Class1 {
    public static void main(String[] args) {
        //Book book = new Book("Book","Bob",1987,54);
        //Book bookJava = new Book("Java Full Guide","Schildt",2012,1000);
        //print(book);
        //System.out.println("bookJava.isJavaBook() = " + bookJava.isJavaBook());
        //System.out.println("book.isJavaBook() = " + book.isJavaBook());
        Meeting meeting = new Meeting("API Methods", "2021-12-02 23:23:32", 23, true);
        System.out.println("meeting.isTopicAboutAPI() = " + meeting.isTopicAboutAPI());
        System.out.println("meeting.isOnline() = " + meeting.isOnline());

        Car lada = new Car("Lada", 10, "Black");
        System.out.println("lada.isOld() = " + lada.isOld());
        System.out.println("lada.isColorBlack() = " + lada.isColorBlack());
        Car bmw = new Car("BMW", 40, "Red");
        System.out.println("bmw.isOld() = " + bmw.isOld());
        System.out.println("bmw.isColorBlack() = " + bmw.isColorBlack());

        Phone samsung = new Phone("Samsung", 2, true, false); // why is it prohibited to put 1/0 for true/false here?
        System.out.println("samsung.isPhoneOkForUse() = " + samsung.isPhoneOkForUse());
        System.out.println("samsung.isIphone() = " + samsung.isIphone());
        Phone iphone = new Phone("iPhone", 1, true, true);
        System.out.println("iphone.isPhoneOkForUse() = " + iphone.isPhoneOkForUse());
        System.out.println("iphone.isIphone() = " + iphone.isIphone());
    }

    static void print(Book book) {
        System.out.println("Book is named as " + book.name + " and author is " + book.author + "The year of issue is " + book.yearOfIssue +
                               " The number of pages" + book.numberOfPages);
    }

    public static class Book {
        String name;
        String author;
        int yearOfIssue;
        int numberOfPages;

        public Book(String name_, String author_, int yearOfIssue_, int numberOfPages_) {
            name = name_;
            author = author_;
            yearOfIssue = yearOfIssue_;
            numberOfPages = numberOfPages_;
        }

        public boolean isJavaBook() { // OOP begins here
            return name.contains("Java"); // метод класса String
        }
    }

    /* Class Meeting */

    public static class Meeting {
        String topic;
        String timeOfStart;
        int numOfParticipants;
        boolean online;

        public Meeting(String topic_, String timeOfStart_, int numOfParticipants_, boolean online_) {
            topic = topic_;
            timeOfStart = timeOfStart_;
            numOfParticipants = numOfParticipants_;
            online = online_;
        }

        public boolean isTopicAboutAPI() {
            return topic.contains("API");
        }

        public String isOnline() {
            return numOfParticipants > 20 ? "The meeting takes place in Zoom" : "The meeting is offline";
        }
    }

    /* Class Car */

    public static class Car {
        String name;
        int age;
        String color;

        public Car(String name_, int age_, String color_) {
            name = name_;
            age = age_;
            color = color_;
        }

        public String isOld() {
            return age < 30 ? "The car is brand-new" : "The car is old";
        }

        public String isColorBlack() {
            if (color.contains("Black")) {
                return "The color is ok";   // why cannot I put here System.out.println() ? It throws the exception.
            }
            else {
                return "Please, change the color!";
            }
        }

    }

    /* Class Phone */

    public static class Phone {
        String name;
        int age;
        boolean hasSensor;
        boolean isActive;

        public Phone(String name_, int age_, boolean hasSensor_, boolean isActive_) {
            name = name_;
            age = age_;
            hasSensor = hasSensor_;
            isActive = isActive_;
        }

        public boolean isPhoneOkForUse() {
            if (hasSensor && isActive) {
                if (age <= 2) {
                    return true;
                }
            }
            return false;
        }

        public boolean isIphone() {
            return name.contains("iPhone");
        }

    }

    /**
     * Structure that holds min and max value that pushed during object existence.
     *
     * For example, if holder - instance of class:
     * holder.push(10);
     * holder.push(22);
     * holder.min(); //-> 10
     * holder.max(); //-> 22
     * holder.push(7);
     * holder.min(); // -> 7;
     * holder.max(); // -> 22;
     * holder.push(42);
     * holder.max(); // -> 42
     */
    public static class MinMaxValueHolder {
        // please implement methods.
        // add necessary fields.

        /**
         * Pushes new value into structure.
         *
         * @param val Any integer;
         */
        public void push(int val) {

        }

        /**
         * Returns minimal value ever pushed into structure.
         */
        public int min() {
            return 0;
        }

        /**
         * Returns maximal value ever pushed into structure.
         */
        public int max() {
            return 0;
        }
    }

}

