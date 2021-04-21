package reflection_examples;

import java.lang.reflect.Field;

public class Example3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //Create regular object instance
        EmployeeNew employeeNew = new EmployeeNew(10, "Alex", "QA");

        //Create Class EmployeeNew instance
        Class employeeNewClass = employeeNew.getClass();

        //Create field instance via reflection API
        Field salaryField = employeeNewClass.getDeclaredField("salary");

        //Set private field as accessible == true
        salaryField.setAccessible(true);

        //Set the value for a field
        salaryField.set(employeeNew, 16500.256);

        double salaryValue = (Double) salaryField.get(employeeNew);
        System.out.println("Emloyee salary = " + salaryValue);
    }
}
