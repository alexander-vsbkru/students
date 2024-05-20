package com.example.students.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private int age;

    public String toString() {
        return firstName + " " + lastName + ", age: " + age;
    }


}
