/*Написать класс mathBox.MathBox , реализующий следующий функционал:
1.Конструктор на вход получает массив Integer. Элементы не могут повторяться.
Элементы массива внутри конструктора раскладываются в подходящую коллекцию (выбрать самостоятельно), являющуюся полем mathBox.MathBox.
Элементы должны отсортироваться
2.Существует метод summator, возвращающий сумму всех элементов коллекции
3.Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
являющийся аргументом метода. Метод возвращает коллекцию с результатами деления. Коллекция внутри mathbox при этом не меняется
4.Необходимо правильно переопределить методы toString , hashCode, equals, чтобы можно было использовать
mathBox.MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap ).
Выполнение контракта обязательно!
5.Есть метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.*/
package mathBox;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class MathBox {
    private TreeSet<Integer> newSet;

    public MathBox() {
        List<Integer> newList = Arrays.asList(new MyArray().randomArray());
        newSet = new TreeSet<Integer>(newList);
    }

    public int summator() {
        int amount = 0;
        for (Integer number : newSet) {
            amount = amount + number;
        }
        return amount;
    }

    public TreeSet<Integer> splitter(int del) {
        for (Integer number : newSet) {
            double newNumber = (double) number / del;
            System.out.println("Делимое " + number + " Делитель " + del + " Частное " + newNumber);
        }
        return newSet;
    }

    public boolean deleteNumber(int deleteNumber) {
        return newSet.remove(deleteNumber);
    }

    @Override
    public String toString() {
        return "mathBox.MathBox{" +
                "newSet=" + newSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(newSet, mathBox.newSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newSet);
    }
}

