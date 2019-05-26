package mathBox;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;

public class ProxyMathBox implements InvocationHandler {
    private MathBox mathBox;

    public ProxyMathBox(MathBox mathBox) {
        this.mathBox = mathBox;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getAnnotation(ClearData.class) != null) {
            Field field = mathBox.getClass().getDeclaredField("newSet");
            field.setAccessible(true);
            Set set = (Set) field.get(mathBox);
            set.clear();
        }
        if (method.getAnnotation(Logged.class) != null) {
            long timer = System.currentTimeMillis();
            System.out.println("Proxy : " + method.getName());
            Object object = method.invoke(mathBox, args);
            System.out.println("Timer : " + (System.currentTimeMillis() - timer));
            return object;
        } else {
            return method.invoke(mathBox, args);
        }
    }
}