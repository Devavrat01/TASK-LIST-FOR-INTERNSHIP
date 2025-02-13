public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;

    public Employee() {
    }

    public Employee(int id, int age, double salary, String name) {
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    // Getter and Setter methods
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
