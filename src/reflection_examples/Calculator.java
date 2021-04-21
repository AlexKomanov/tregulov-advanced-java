package reflection_examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
    void sum(int a, int b) {
        int result = a + b;
        System.out.println("Summary of " + a + " and " + b + " = " + result);
    }

    void subtraction(int a, int b) {
        int result = a - b;
        System.out.println("Subtraction of " + a + " and " + b + " = " + result);
    }

    void multiplication(int a, int b) {
        int result = a * b;
        System.out.println("Multiplication of " + a + " and " + b + " = " + result);
    }

    void division(int a, int b) {
        int result = a / b;
        System.out.println("Division of " + a + " and " + b + " = " + result);
    }
}

class TestCalculator {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(

                //Define file to read from
                new FileReader("src/reflection_examples/resource/testCalculator.txt"))) {

            String methodNameFromTextFile = bufferedReader.readLine(); //Read the line with a method name
            String firstArgument = bufferedReader.readLine(); //Read the line with a first parameter
            String secondArgument = bufferedReader.readLine(); //Read the line with a second parameter

            //Create Calculator class instance
            Calculator calculator = new Calculator();
            Class calcClass = calculator.getClass();
            Method methodToInvoke = null;

            //Get all calculator methods
            Method[] declaredMethods = calcClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.getName().equals(methodNameFromTextFile)){
                    methodToInvoke = declaredMethod;
                }
            }

            methodToInvoke.invoke(calculator, Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
