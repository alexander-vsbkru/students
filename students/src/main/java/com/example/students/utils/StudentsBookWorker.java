package com.example.students.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class StudentsBookWorker {
    private final StudentsBook studentsBook;
    private final ApplicationEventPublisher publisher;

    @ShellMethod
    public void  add() {
        System.out.println("Student add!");
        AddStudentEvent event = new AddStudentEvent(this, 1, new Student("Andrey", "Vasiliev", 1));
        publisher.publishEvent(event);
    }

    @ShellMethod
    public void  delete() {
        System.out.println("Student delete!");
        DeleteStudentEvent event = new DeleteStudentEvent(this, 1);
        publisher.publishEvent(event);
    }

    @ShellMethod
    public void list() {
        System.out.println(studentsBook.toString());
    }
}
