package com.example.students.event;

import com.example.students.domain.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.text.MessageFormat;

@Getter
public class AddStudentEvent extends ApplicationEvent {
    private final int id;
    private final Student student;

    public AddStudentEvent(Object source, int id, Student student) {
        super(source);
        this.id = id;
        this.student = student;
    }

    public String getMessage() {
        return MessageFormat.format("Add student: {0} {1}, age: {2} with id {3}",
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                id);
    }
}
