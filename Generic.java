package lesson1.task1and2;

import java.util.ArrayList;

public class Generic<E> {

    private E[] array;
    private int size;

    public Generic(int size) {
        this.size = size;
        this.array = (E[])new Object[size];
    }

    public void add(E value, int i){
        array[i] = value;
    }

    //метод, меняющий местами два элемента массива
    public void exchange(int a, int b) {
        E temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public ArrayList<E> convertArrayToArraylist(){
        ArrayList<E> arrayList =new ArrayList<>();
        for (E e : array) {
            arrayList.add(e);
        }
        return arrayList;
    }
}
