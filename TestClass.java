package lesson7;

import lesson7.Annotations.AfterSuite;
import lesson7.Annotations.BeforeSuite;
import lesson7.Annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class TestClass {

    //создадим список методов для формирования согласно правилам и дальнейшего исполнения
    private final static ArrayList<Method> testMethods = new ArrayList<>();

    //переопределенный метод start(), принимающий имя класса в строке
    private static void start(Class<?> targetClass) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Method[] methods = targetClass.getDeclaredMethods();
        //после получения методов из класса по очереди добавляем методы в список согласно правилам
        addTestMethodsToList(methods);
        addBSMethodToList(methods);
        addASMethodToList(methods);
        //выполняем итоговый список методов
        invokeMethods(targetClass);
    }

    private static void start(String className) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        start(Class.forName(className));
    }

    //Добавляем к списку методов те, что с аннотацией @Test
    private static void addTestMethodsToList(Method[] methods) {
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }
        //и сортируем их в порядке убывания преоритета
        testMethods.sort((Method a, Method b) -> b.getAnnotation(Test.class).priority() - a.getAnnotation(Test.class).priority());
    }

    //добавляем к списку методов те, что с аннотацией @BeforeSuite
    private static void addBSMethodToList(Method[] methods) {
        boolean flag = false;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (flag) {
                    throw new RuntimeException("More then 1 @BeforeSuite annotation in class");
                } else {
                    testMethods.add(0, method); //добавляем в начало списка
                    flag = true;
                }
            }
        }
    }

    //добавляем к списку методов те, что с аннотацией @AfterSuite
    private static void addASMethodToList(Method[] methods) {
        boolean flag = false;
        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (flag) {
                    throw new RuntimeException("More then 1 @AfterSuite annotation in class");
                } else {
                    testMethods.add(method); //добавляем в конец списка
                    flag = true;
                }
            }
        }
    }

    //исполняем сформированный список методов
    private static void invokeMethods(Class<?> targetClass) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //создадим тестовый объект класса и выполним его методы по сформированному списку
        Object testObject = targetClass.getConstructor().newInstance();
        for (Method testMethod : testMethods) {
            testMethod.setAccessible(true);
            testMethod.invoke(testObject);
        }
    }
}
