public class InheritanceDemo {
    public static void main(String[] args) {
        Cow cow = new Cow("Alpine", "Burenka");
        Bug bug = new Bug("Bug", "black");
        System.out.println("cow.name = " + cow.name);
        cow.makeSound();
        Animal animal = cow;
        animal.makeSound(2);

    }

    static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        public void makeSound() {

        }

        public void makeSound(int times) {

        }

    }

    static class Cow extends Animal {
        String strain;
        String name;

        public Cow(String strain, String name) {
            super("Cow");
            this.strain = strain;
            this.name = name;
        }

        @Override
        public void makeSound(int times) {
            for (int i = 0; i < times; i++) {
                System.out.println("Mooooooooooooo");
            }
        }

        @Override
        public void makeSound() {
            makeSound(1);
        }
    }

    static class Bug extends Animal {
        String color;

        public Bug(String name, String color) {
            super(name);
            this.color = color;
        }

        public void makeSound() {
            System.out.println("Bzzzzzzzzzzzzzzzzzzz");
        }
    }

    // new class to create:
    //classes: figure (area + per) --> three subclasses
    // new task with node
}
