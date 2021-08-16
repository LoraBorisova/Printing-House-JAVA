package com.company;

public class Employee {
    private EmployeeType type;
    private static double salary = 1200;

    public Employee(EmployeeType type) {
        this.type = type;
    }

    public EmployeeType getType() {
        return type;
    }


    public void setType(EmployeeType type) {
        this.type = type;
    }

    public static double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "type=" + type +
                '}';
    }

}



