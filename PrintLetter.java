package lesson4;

public class PrintLetter {
    //создаем переменную с хранением "предыдущей буквы"
    private String letter = "C";

    //объединенный универсальный метод для вывода букв
    public synchronized void printLetter(String inLetter) {
        //рекурсию заменем на бесконечный цикл
        while (true) {
            if (letter.equals("C") & inLetter.equals("A")) {
                System.out.print(letter = "A");
                notifyAll();
                break;
            } else if (letter.equals("A") & inLetter.equals("B")) {
                System.out.print(letter = "B");
                notifyAll();
                break;
            } else if (letter.equals("B") & inLetter.equals("C")) {
                System.out.print(letter = "C");
                notifyAll();
                break;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
