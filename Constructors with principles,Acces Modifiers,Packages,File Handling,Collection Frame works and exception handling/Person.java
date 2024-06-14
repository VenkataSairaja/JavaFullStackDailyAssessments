//Define a Java class Person with instance variables name (private), age (protected), and address (default/package-private). Provide getter and setter methods for name and demonstrate accessing age and address from a subclass in a different package.
public class Person {
    private String name;
    protected int age;
    String address;

    public Person() {}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

// Subclass in a different package
package com.example.subclass;

import com.example.person.Person;

public class Employee extends Person {
    public Employee() {}

    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Address: " + getAddress());
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setAge(30);
        employee.setAddress("123 Main St");
        employee.displayDetails();
    }
}