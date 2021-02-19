package lesson4;

public class PrintLetter {
    //создаем переменную с хранением "предыдущей буквы"
    private String letter = "";

    public synchronized void printLetterA() {
        //проверяем, что предыдущая буква "С" или пустая строка
        if (letter.equals("C") | letter.isBlank() ) {
            System.out.print(letter = "A"); //если да, то присваиваем letter значение "С" и выводим на экран
            notifyAll(); //и будим другие потоки
        } else {
            try {
                wait(); //если предыдущая буква иная, то "засыпаем"
                printLetterA(); //при пробуждении вызываем этот же метод для проверки буквы
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //остальные методы по аналогии
    public synchronized void printLetterB() {

        if (letter.equals("A")) {
            System.out.print(letter = "B");
            notifyAll();
        } else {
            try {
                wait();
                printLetterB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void printLetterC() {

        if (letter.equals("B")) {
            System.out.print(letter = "C");
            notifyAll();
        } else {
            try {
                wait();
                printLetterC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
