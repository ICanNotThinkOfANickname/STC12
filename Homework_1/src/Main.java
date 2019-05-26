import mathBox.MathBox;

public class Main {
    public static void main(String[] args) throws Exception {
        MathBox mathBox = new MathBox();
        System.out.println(mathBox.summa(5, 3));
        System.out.println(mathBox.diff(5, 2));
        System.out.println(mathBox.dividerExceptionInside(4, 0));
        try {
            System.out.println(mathBox.divider(4, 0));
        } catch (Exception e) {
            System.out.println("Error : division by zero");
        }
        System.out.println(mathBox.factorial(-4)); //StackOverflowError с отрицательным числом
    }
}
