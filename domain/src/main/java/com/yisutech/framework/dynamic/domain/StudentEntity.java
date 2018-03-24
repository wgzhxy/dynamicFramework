package com.yisutech.framework.dynamic.domain;

/**
 * 学生对象
 *
 * @author guangzhong.wgz
 */
public class StudentEntity {

    /**
     * 姓名
     */
    String name;
    /**
     * 年龄
     */
    String age;
    /**
     * 班级
     */
    String className;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
