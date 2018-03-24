package com.yisutech.framework.dynamic;

import com.yisutech.framework.dynamic.gvyobject.Student;
import groovy.lang.GroovyObject;

/**
 * JAVA调用Groovy代码
 */
public class DynamicMain {

    public static void main(String[] args) {
        GroovyObject student = new Student("小王", 32, "计科032班");
        student.setProperty("name", "李小明");
        student.setProperty("age", "100");
        student.setProperty("className", "计科031班");
        student.invokeMethod("printStudent", null);
    }
}
