public class Animal {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.walk();
    }
}

abstract class AnimalBase{
    void eat(){
        System.out.println("Eats vegies");
    }
    abstract void walk();
}

class Dog extends AnimalBase{
    @Override
    void eat() {
//        super.eat();
        System.out.println("eat brade");
    }

    @Override
    void walk() {
        System.out.println("walks and run !");
    }
}