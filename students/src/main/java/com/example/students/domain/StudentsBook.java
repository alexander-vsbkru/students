package com.example.students.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;

@RequiredArgsConstructor
@Getter
@Component
public class StudentsBook {
    private final HashMap<Integer, Student> studentsMap;

    public int add(Student student) {
        int id = 0;
        if (!studentsMap.isEmpty()) id = Collections.max(studentsMap.keySet()) + 1;
        studentsMap.put(id, student);
        return id;
    }

    public void delete(int id) {
        studentsMap.remove(id);
    }

    public void clean() {
        studentsMap.clear();
    }

    public String toString() {
        if (studentsMap.isEmpty()) return "Students List is clean!";
        String response = "Students List" + System.lineSeparator();
        for (int id : studentsMap.keySet()) {
            response = response.concat(id + ". " + studentsMap.get(id).toString() + System.lineSeparator());
        }
        return response;
    }
}
