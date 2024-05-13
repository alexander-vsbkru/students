package com.example.students.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
