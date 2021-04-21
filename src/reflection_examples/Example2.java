package reflection_examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Example2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class employeeClass = Class.forName("reflection_examples.Employee");

        /**Deprecated method of Object creation*/
        Employee o = (Employee) employeeClass.newInstance();
        //System.out.println(o);

        /** Recommended method of Object creation*/
        Constructor<Employee> constructor1 = employeeClass.getConstructor();
        Employee obj1 = constructor1.newInstance();

        /** Create Employee object using constructor with parameters*/
        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        Employee employeeObject = (Employee) constructor2.newInstance(5, "Alex", "QA");
        System.out.println(employeeObject);

        /** Create method instance */
        Method setSalaryMethod = employeeClass.getMethod("setSalary", double.class);
        setSalaryMethod.invoke(employeeObject, 16500.567);
        System.out.println(employeeObject);



    }
}
