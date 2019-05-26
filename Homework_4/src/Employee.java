/*Существует класс Employee с полями name, age, salary, job. Типы необходимо выбрать самостоятельно. Задание:

1.Реализовать следующие методы:
a.boolean save (Employee), дописывающий сотрудника в конец файла
b.boolean delete (Employee), удаляющий сотрудника из файла
c.Employee getByName (тип name), возвращающий сотрудника по полному совпадению имени
d.List<Employee> getByJob(тип job), возвращающий список сотрудников по должности
e.boolean saveOrUpdate (Employee), выполняющий обновление, либо сохранение сотрудника в зависимости от того, есть ли он уже в файле
f.boolean changeAllWork (какую должноcть, на какую должность), выполняющий замену заданной должности на заданную для всех сотрудников
g.Используем сериализацию/десериализацию «Из коробки»

2.Доп. Задание (+10%) в конец файла дописывать сумму зарплат всех сотрудников (с помощью Externalizable)
3.Доп. Задание (+10%) сделать все на кастомной сериализции/десериализации (BufferedReader/BufferedWriter)*/


import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
    List<Employee> arrayEmployee = new ArrayList<>();
    private String name;
    private int age;
    private int salary;
    private String job;

    public Employee(String name, int age, int salary, String job) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getJob() {
        return job;
    }

    boolean writeToFile(Employee employee) {
        Writer writer = null;
        try {
            writer = new FileWriter("Employee.txt", true);
            for (Employee list : arrayEmployee) {
                writer.write(String.valueOf(list) + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
        return false;
    }

    boolean save(Employee employee) {
        arrayEmployee.add(employee);
        writeToFile(employee);
        return false;
    }

    boolean delete(Employee employee) {
        arrayEmployee.remove(employee);
        writeToFile(employee);
        return false;
    }

    boolean getByName(String name) {
        for (Employee list : arrayEmployee) {
            if (list.equals(name)) {
                System.out.println("You found an employee named " + name);
            } else {
                System.out.println("Not found");
            }
        }

        return false;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                '}';
    }
}