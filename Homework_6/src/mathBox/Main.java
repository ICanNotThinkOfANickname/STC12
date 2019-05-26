package mathBox;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        MathBox mathBox = new MathBox();
        ProxyMathBox proxyMathBox = new ProxyMathBox(mathBox);
        Object object = Proxy.newProxyInstance(ProxyMathBox.class.getClassLoader(), MathBox.class.getInterfaces(), proxyMathBox);
        System.out.println(mathBox.toString());
        System.out.println(mathBox.summator());
        System.out.println(mathBox.splitter(2));
        System.out.println(mathBox.deleteNumber(1));

        System.out.println(object);
    }
}
