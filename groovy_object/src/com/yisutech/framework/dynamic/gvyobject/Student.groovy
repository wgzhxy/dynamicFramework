package com.yisutech.framework.dynamic.gvyobject

/**
 * 学生对象
 *
 * @author guangzhong.wgz@alibaba-inc.com
 *
 */
class Student {

    def name;
    def age;
    def className;

    Student() {}

    Student(def name, def age, def className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    void printStudent() {
        println(this.name + "_____" + this.age + "_____" + this.className);
    }

    void printStudent(def name, def age) {
        println(name + "_____" + age);
    }
}
