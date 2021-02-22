package lesson4;

public class Main {

    public static void main(String[] args) {

        PrintLetter printLetter = new PrintLetter();
        // создаем три потока и вызываем синхронизированный метод вывода, на который отправляем нужную букву
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printLetter.printLetter("A");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printLetter.printLetter("B");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printLetter.printLetter("C");
            }
        }).start();
    }
}
