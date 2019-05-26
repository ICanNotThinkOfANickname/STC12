package mathBox;

import java.util.Random;

public class MyArray {
    Random random = new Random();

    public Integer[] randomArray() {
        Integer[] array = new Integer[10];
        boolean numberAlreadyExists;
        for (int i = 0; i < array.length; ) {
            numberAlreadyExists = false;
            int newRandomValue = random.nextInt(100);
            for (int j = 0; j < i; j++) {
                if (array[j] == newRandomValue) {
                    numberAlreadyExists = true;
                    break;
                }
            }
            if (!numberAlreadyExists) {
                array[i] = newRandomValue;
                i++;
            }
        }
        return array;
    }

}
