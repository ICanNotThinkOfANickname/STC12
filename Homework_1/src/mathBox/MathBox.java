package mathBox;

public class MathBox {
    public int summa(Integer a, Integer b) {
        int result = 0;
        result = a + b;
        return result;
    }

    public int diff(Integer a, Integer b) {
        int result = 0;
        result = a - b;
        return result;
    }

    public long factorial(Integer a) {
        long result;
        if (a == 1) return 1;
        result = factorial(a - 1) * a;
        return result;
    }

    public double dividerExceptionInside(Integer a, Integer b) {
        double result = 0;
        if (b == 0.0) {
            System.out.print("You can't divide it by zero : ");

        } else {
            result = a / b;
        }
        return result;
    }

    public double divider(Integer a, Integer b) throws Exception {
        double result;
        result = a / b;
        return result;
    }
}