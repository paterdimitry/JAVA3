package lesson4;

public class Main {

    public static void main(String[] args) {

        PrintLetter printLetter = new PrintLetter();
        // создаем три потока и вызываем синхронизированные методы вывода отдельных букв
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printLetter.printLetterA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printLetter.printLetterB();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printLetter.printLetterC();
            }
        }).start();
    }
}
