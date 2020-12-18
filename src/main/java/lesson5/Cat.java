package lesson5;

public class Cat extends Animal{

    Cat(String name, float maxJump, float maxRun, float maxSwim) {
        super("Кот‚", name, maxJump, maxRun, maxSwim);
    }

    @Override
    protected int swim(float distance) {
        return Animal.SWIM_NONE;
    }
}