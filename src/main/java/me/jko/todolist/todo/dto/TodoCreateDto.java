package me.jko.todolist.todo.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

public class TodoCreateDto {

  @NotEmpty
  private String title;

  @NotEmpty
  private String description;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dueDate;

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }
}
