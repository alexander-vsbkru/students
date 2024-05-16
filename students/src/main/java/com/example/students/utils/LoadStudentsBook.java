package com.example.students.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
@ConditionalOnProperty("app.load-on-start.enabled")
public class LoadStudentsBook extends StudentsBook{
    @Value("${app.load-from-file}")
    String path;

    public LoadStudentsBook(HashMap<Integer, Student> studentsMap) {
        super(studentsMap);
    }
    @EventListener(ApplicationStartedEvent.class)
    public void starting() throws IOException {
        loadFromFile();
    }

    public void loadFromFile() throws IOException {
        InputStream is = new ClassPathResource(path).getInputStream();
        List<String> studentsFromFile = new ArrayList<>();
        try {
            String studentsInFile = new String(FileCopyUtils.copyToByteArray(is), StandardCharsets.UTF_8);
            studentsFromFile = Arrays.stream(studentsInFile.split("\n")).toList();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            is.close();
        }

        if (!studentsFromFile.isEmpty()) {
            for(String line : studentsFromFile) {
              String[] record = line.split(" ");
               String firstName = record[0];
                String lastName = record[1];
                int age = Integer.parseInt(record[2].trim());
                add(new Student(firstName, lastName, age));
            }
        }
    }
}
