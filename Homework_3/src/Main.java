import objectBox.ObjectBox;

public class Main {
    public static void main(String[] args) {
        ObjectBox objectBox = new ObjectBox();
        objectBox.add(4);
        objectBox.add(5);
        objectBox.add(99);
        System.out.println(objectBox.dump());
        objectBox.find(4);
    }
}
