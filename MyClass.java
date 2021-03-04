package lesson7;

import lesson7.Annotations.AfterSuite;
import lesson7.Annotations.BeforeSuite;
import lesson7.Annotations.Test;

public class MyClass {

    public MyClass() {
    }

    @BeforeSuite
    void write1() {
        System.out.println("111");
    }

    @Test(priority = 7)
    void write2() {
        System.out.println("333");
    }

    @Test
    void write3() {
        System.out.println("444");
    }

    @Test(priority = 9)
    void write4() {
        System.out.println("222");
    }

    @AfterSuite
    void write5() {
        System.out.println("555");
    }
}
