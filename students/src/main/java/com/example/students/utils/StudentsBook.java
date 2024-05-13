package com.example.students.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;

@RequiredArgsConstructor
@Getter
@Component
public class StudentsBook {
    private final HashMap<Integer, Student> studentsMap;

    public int add(Student student) {
        int id = Collections.max(studentsMap.keySet()) + 1;
        studentsMap.put(id, student);
        return id;
    }

    public int delete(int id) {
        studentsMap.remove(id);
        return id;
    }

    public void clear() {
        studentsMap.clear();
    }

    public String toString() {
        String response = "Список студентов" + System.lineSeparator();
        for (int id : studentsMap.keySet()) {
            response = response.concat(id + ". " + studentsMap.get(id).toString());
        }
        return response;
    }
}
