package lesson1.task3;

import java.util.ArrayList;

public class Box<E extends Fruit> {

    private ArrayList<E> fruits;

    public Box() {
        this.fruits = new ArrayList<>();

    }

    public double getWeight() {
        double sum = 0;
        for (E fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public void add(E value) {
        fruits.add(value);
    }

    public void add(E value, int n) {
        for (int i = 0; i < n; i++) {
            fruits.add(value);
        }
    }

    public boolean compare(Box<?> secondBox) {
        return Math.abs(this.getWeight() - secondBox.getWeight()) < 0.001;
    }

    public void fill(Box<E> secondBox) {
        for (E fruit : fruits) {
            secondBox.add(fruit);
        }
        fruits.clear();
    }
}
