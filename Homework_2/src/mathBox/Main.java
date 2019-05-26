package mathBox;

public class Main {
    public static void main(String[] args) {
        MathBox mathBox = new MathBox();
        System.out.println(mathBox.toString());
        System.out.println(mathBox.summator());
        System.out.println(mathBox.splitter(2));
        System.out.println(mathBox.deleteNumber(1));
    }
}
