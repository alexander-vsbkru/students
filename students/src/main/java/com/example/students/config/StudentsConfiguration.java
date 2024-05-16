package com.example.students.config;

import com.example.students.utils.LoadStudentsBook;
import com.example.students.utils.StudentsBookWorker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(LoadStudentsBook.class)
public class StudentsConfiguration {
    @Bean
    public StudentsBookWorker studentsBookWorker(LoadStudentsBook studentsBook, ApplicationEventPublisher publisher) {
        return new StudentsBookWorker(studentsBook, publisher);
    }
}
