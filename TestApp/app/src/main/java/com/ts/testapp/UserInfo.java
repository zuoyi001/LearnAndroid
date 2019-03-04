package com.ts.testapp;

public class UserInfo {

    private String name;

    private int age;

    /** * FastJSON要求：需要提供默认构造方法 */
    public UserInfo() {}

    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
