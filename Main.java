package lesson1.task3;

public class Main {
    public static void main(String[] args) throws Exception {
        Box<Apple> box1 = new Box<>(Apple.class);
        Box<Apple> box2 = new Box<>(Apple.class);
        Box<Orange> box3 = new Box<>(Orange.class);

        box1.add(new Apple(), 4);
        box2.add(new Apple(), 6);
        box3.add(new Orange(), 4);

        //проверка
        System.out.println("В коробке 1: " + box1.getWeight());
        System.out.println("В коробке 2: " + box2.getWeight());
        System.out.println("В коробке 3: " + box3.getWeight());
        System.out.println("коробка 1 vs коробка 2 " + box1.compare(box2));
        System.out.println("коробка 2 vs коробка 3 " + box2.compare(box3));
        box1.fill(box2);
        System.out.println("В коробке 2 стало: " + box2.getWeight());
        System.out.println("В коробке 1 стало: " + box1.getWeight());
    }
}
