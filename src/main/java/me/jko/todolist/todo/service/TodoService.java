package me.jko.todolist.todo.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import me.jko.todolist.todo.dto.TodoCreateDto;
import me.jko.todolist.todo.dto.TodoUpdateDto;
import me.jko.todolist.todo.entity.Todo;
import me.jko.todolist.todo.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

  private final TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public Todo saveTodoBy(TodoCreateDto todoCreateDto) {
    Todo todo = new Todo();
    todo.setTitle(todoCreateDto.getTitle());
    todo.setDescription(todoCreateDto.getDescription());
    todo.setDueDate(todoCreateDto.getDueDate());

    return todoRepository.save(todo);
  }

  public List<Todo> getTodos() {
    return todoRepository.findAll();
  }

  public Todo getTodoBy(Long id) {
    return todoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public Todo updateTodoBy(Long todoId, TodoUpdateDto todoUpdateDto) {
    Todo todo = todoRepository.findById(todoId).orElseThrow(EntityNotFoundException::new);
    todo.setTitle(todoUpdateDto.getTitle());
    todo.setDescription(todoUpdateDto.getDescription());
    todo.setDueDate(todoUpdateDto.getDueDate());

    return todoRepository.save(todo);
  }

  public void deleteOwnerBy(Long todoId) {
    Todo todo = todoRepository.findById(todoId).orElseThrow(EntityNotFoundException::new);
    todoRepository.delete(todo);
  }
}
