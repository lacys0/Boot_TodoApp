package com.laszlo.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn; // New import
import jakarta.persistence.ManyToOne; // New import
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;
  private LocalDate dueDate;

  // New: Many TodoItems can belong to one Subject
  @ManyToOne
  @JoinColumn(
      name = "subject_id") // This specifies the foreign key column name in the todo_item table
  private Subject subject; // This will hold the associated Subject object

  public boolean isCompleted() {
    return dueDate != null && dueDate.isBefore(LocalDate.now());
  }

  public TodoItem(String description, LocalDate dueDate, Subject subject) {
    this.description = description;
    this.dueDate = dueDate;
    this.subject = subject; // Initialize the subject
  }
}
