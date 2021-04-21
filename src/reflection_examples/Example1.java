package reflection_examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

        //Create Object of Class class
        Class employeeClass = Class.forName("reflection_examples.Employee");

 /*       //Another options to create Object of Class class
        Class employeeClass2 = Employee.class;
        Employee employee = new Employee();
        Class employeeClass3 = employee.getClass();
*/

        // Get type of the field
        Field idField = employeeClass.getField("id");
        System.out.println("The type of 'id' field --> " + idField.getType());
        System.out.println("<-----------------------> ");

        // Get fields from the class (without private fields)
        Field[] fields = employeeClass.getFields();

        for (Field field : fields) {
            System.out.println("Type of " + field.getName() + " is --> " + field.getType());
        }

        System.out.println("<-----------------------> ");

        // Get ALL fields from the class (include private fields)
        Field[] allFields = employeeClass.getDeclaredFields();
        for (Field declaredField : allFields) {
            System.out.println("Type of " + declaredField.getName() + " is --> " + declaredField.getType());
        }

        System.out.println("<-----------------------> ");

        // Get method information
        Method employeeIncreaseSalary = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method " + employeeIncreaseSalary.getName() + " is --> " + employeeIncreaseSalary.getReturnType() +
                ", parameters types are --> " + Arrays.toString(employeeIncreaseSalary.getParameterTypes()));

        System.out.println("<-----------------------> ");

        // Get method information
        Method setSalaryMethod = employeeClass.getMethod("setSalary", double.class);
        System.out.println("Return type of method " + setSalaryMethod.getName() + " is --> " + setSalaryMethod.getReturnType() +
                ", parameters types are --> " + Arrays.toString(setSalaryMethod.getParameterTypes()));

        System.out.println("<-----------------------> ");

        // Get methods of the Class (without private methods, with inherited methods)
        Method[] methods = employeeClass.getMethods();
        for (Method method : methods) {
            System.out.println("Return type of method '" + method.getName() + "' is --> " + method.getReturnType() +
                    ", parameters types are --> " + Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("<-----------------------> ");

        // Get methods of the Class (with private methods, without inherited methods)
        Method[] allMethods = employeeClass.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println("Return type of method '" + method.getName() + "' is --> " + method.getReturnType() +
                    ", parameters types are --> " + Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("<-----------------------> ");

        // Get public methods of the Class (without inherited methods)
        Method[] allPublicMethods = employeeClass.getDeclaredMethods();
        for (Method method : allPublicMethods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println("Return type of method '" + method.getName() + "' is --> " + method.getReturnType() +
                        ", parameters types are --> " + Arrays.toString(method.getParameterTypes()));
            }
        }

        System.out.println("<-----------------------> ");

        // Get constructor information (default constructor)
        Constructor constructor1 = employeeClass.getConstructor();
        System.out.println("Constructor has " + constructor1.getParameterCount() +  " parameters, " +
                "their types are " + Arrays.toString(constructor1.getParameterTypes()));

        System.out.println("<-----------------------> ");

        // Get constructor information (constructor with parameters)
        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        System.out.println("Constructor has " + constructor2.getParameterCount() +  " parameters, " +
                "their types are " + Arrays.toString(constructor2.getParameterTypes()));

        System.out.println("<-----------------------> ");

        // Get constructors information (ALL class constructors)
        Constructor[] constructors = employeeClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Constructor " + constructor.getName() + " has " + constructor.getParameterCount() +  " parameters, " +
                    "their types are " + Arrays.toString(constructor.getParameterTypes()));
        }
    }
}
