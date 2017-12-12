/**
* Java. Level 1. HomeWork6
*
* @author Pavel Bulin
* @version 12.12.2017
* @link https://github.com/PavelBulin/git-repo.git
*/

class HomeWork6 {

    public static void main(String[] args) {
        Cat cat = new Cat("Cat Vasiliy");
        Dog dog = new Dog("Dog Sharik", "swim");
        System.out.println(cat + " can run " + cat.run() + " and jump " + cat.jump());
        System.out.println(dog + " can run " + dog.run() + ", jump " + dog.jump() + " and swim " + dog.swim);
    }
}

abstract class Animal {
    String name;
    
    Animal(String name) {
        this.name = name;
    }

    abstract String run();

    abstract String jump();

    @Override
    public String toString() {
        return name;
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    public String run() {
        return "200 m";
    }

    @Override
    public String jump() {
        return "2 m";
    }
}

class Dog extends Animal {
    String swim;
    
    Dog(String name, String swim) {
        super(name);
        this.swim = "10 m";
    }

    @Override
    public String run() {
        return "500 m";
    }

    //@Override
    String jump() {
        return "0,5 m";
    }
}