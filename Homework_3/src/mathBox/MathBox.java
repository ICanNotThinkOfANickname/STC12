package mathBox;

import objectBox.ObjectBox;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class MathBox extends ObjectBox {
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

