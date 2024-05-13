package com.example.students.utils;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@ConditionalOnProperty("app.load-on-start.enabled")
public class LoadStudentsBook extends StudentsBook{
    public LoadStudentsBook(HashMap<Integer, Student> studentsMap) {
        super(studentsMap);
    }
    @EventListener(ApplicationStartedEvent.class)
    public void starting() {
        System.out.println("start");
        super.getStudentsMap().put(1, new Student("Ivan", "Ivanov", 16));
    }

}
