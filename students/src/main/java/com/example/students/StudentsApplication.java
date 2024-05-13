package com.example.students;

import com.example.students.utils.AddStudentEvent;
import com.example.students.utils.DeleteStudentEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class StudentsApplication {

	boolean start = false;
	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);

	}

/*	@EventListener(ApplicationStartedEvent.class)

    public void starting() {
		System.out.println("start");
		start = true;
}*/

    @EventListener
	public void addStudentEventListener(AddStudentEvent eventHolder) {
       System.out.println(eventHolder.getMessage());
	   System.out.println(start);
	}

	@EventListener
	public void deleteStudentEventListener(DeleteStudentEvent eventHolder) {
		System.out.println(eventHolder.getMessage());
	}

}
