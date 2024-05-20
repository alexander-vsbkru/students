package com.example.students.domain;

import com.example.students.event.AddStudentEvent;
import com.example.students.event.DeleteStudentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class StudentsBookWorker {
    private final StudentsBook studentsBook;
    private final ApplicationEventPublisher publisher;

    @ShellMethod
    public void  add(@ShellOption(value = "f") String firstName,
                     @ShellOption(value = "l") String lastName,
                     @ShellOption(value = "a") int age) {
        Student student = new Student(firstName, lastName, age);
        int id = studentsBook.add(student);
        AddStudentEvent event = new AddStudentEvent(this, id, student);
        publisher.publishEvent(event);
    }

    @ShellMethod
    public void delete(int id) {
        studentsBook.delete(id);
        DeleteStudentEvent event = new DeleteStudentEvent(this, id);
        publisher.publishEvent(event);
    }

    @ShellMethod
    public void list() {
        System.out.println(studentsBook);
    }

    @ShellMethod
    public void clean() {
        studentsBook.clean();
        System.out.println(studentsBook);
    }

    @EventListener
    public void addStudentEventListener(AddStudentEvent eventHolder) {
        System.out.println(eventHolder.getMessage());
    }

    @EventListener
    public void deleteStudentEventListener(DeleteStudentEvent eventHolder) {
        System.out.println(eventHolder.getMessage());
    }

}
