package com.example.students.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.text.MessageFormat;

@Getter
public class DeleteStudentEvent extends ApplicationEvent {
   private final int id;

   public DeleteStudentEvent(Object source, int id) {
      super(source);
      this.id = id;
   }

   public String getMessage() {
      return MessageFormat.format("Student with id {0} deleted", id);
   }
}
