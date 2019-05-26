
public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Jack", 30, 10000, "IBM");
        Employee employee2 = new Employee("John", 20, 7000, "Apple");
        //employee1.save(employee1);
        //employee2.save(employee2);
        employee1.delete(employee1);
        employee1.getByName("Jack");
    }
}
