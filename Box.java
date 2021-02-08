package lesson1.task3;

import java.util.ArrayList;

public class Box<E extends Fruit> {

    private ArrayList<E> fruits;
    private E obj;

    public Box(Class<E> eClass) throws Exception {
        this.fruits = new ArrayList<>();
        obj = eClass.newInstance(); //создаем объект полученного класса, чтобы потом взять у него метод getWeight();
    }

    public void add(E value) {
        fruits.add(value);
    }

    public void add(E value, int n) {
        for (int i = 0; i < n; i++) {
            fruits.add(value);
        }
    }

    public double getWeight() {
            return obj.getWeight() * fruits.size();
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
