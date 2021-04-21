package reflection_examples;

public class EmployeeNew {

    public int id;
    public String name;
    public String department;
    private double salary;

    public EmployeeNew() {
    }

    public EmployeeNew(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    private void changeDepartment(String newDepartment){
        department = newDepartment;
        System.out.println("New department is = " + department);
    }

    public void increaseSalary(){
        salary *= 2;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
