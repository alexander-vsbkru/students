package com.example.students;

import com.example.students.utils.AddStudentEvent;
import com.example.students.utils.DeleteStudentEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);

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
