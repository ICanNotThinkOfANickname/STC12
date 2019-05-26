package objectBox;

/*Создать класс ObjectBox, который будет хранить коллекцию Object. В нем должны быть все методы из MathBox.
Методы должны работать корректно когда все элементы коллекции-Number.
Если в коллекции есть не Number, должен бросаться Exception, разработанный самостоятельно.
У класса должен быть метод addObject, добавляющий объект в коллекцию.
У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции.
Должен быть метод dump, выводящий содержимое коллекции в строку.

___________________

Вторая часть задания, творческая:
Получившиеся классы MathBox и ObjectBox не имеют связи между собой. Это неправильно.
Логичнее было бы сделать MathBox наследником ObjectBox. Необходимо сделать такую связь, правильно распределить поля и методы.
Функциональность в целом должна сохраниться. Руководствуемся здравым смыслом и своей фантазией.
Задание выполняется в одной ветке. Каждая часть в отдельном пакете.*/


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectBox {
    private List<Object> newList;

    public ObjectBox() {
        this.newList = new ArrayList<>(10);
    }

    public void add(Object object) {
        newList.add(object);
    }

    public String dump() {
        return "ObjectBox{" +
                "newList=" + newList +
                '}';
    }

    public void find(Object object) {
        for (Object o : newList) {
            if (o.equals(object)) {
                System.out.println("Object found " + o);
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox objectBox = (ObjectBox) o;
        return Objects.equals(newList, objectBox.newList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newList);
    }
}