package me.jko.todolist.todo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import me.jko.todolist.todo.dto.TodoCreateDto;
import me.jko.todolist.todo.dto.TodoUpdateDto;
import me.jko.todolist.todo.entity.Todo;
import me.jko.todolist.todo.service.TodoService;

import java.util.List;

@RestController
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @PostMapping("/todos")
  public Todo createTodo(@Valid TodoCreateDto todoCreateDto) {
    return todoService.saveTodoBy(todoCreateDto);
  }

  @GetMapping("/todos")
  public List<Todo> getTodos() {
    return todoService.getTodos();
  }

  @GetMapping("/todos/{todoId}")
  public Todo getTodo(@PathVariable Long todoId) {
    return todoService.getTodoBy(todoId);
  }

  @PutMapping("/todos/{todoId}")
  public Todo updateTodoBy(@PathVariable Long todoId, @Valid TodoUpdateDto todoUpdateDto) {
    return todoService.updateTodoBy(todoId, todoUpdateDto);
  }

  @DeleteMapping("/todos/{todoId}")
  public void deleteTodoBy(@PathVariable Long todoId) {
    todoService.deleteOwnerBy(todoId);
  }
}
