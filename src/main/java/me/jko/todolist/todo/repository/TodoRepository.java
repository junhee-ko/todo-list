package me.jko.todolist.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.jko.todolist.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
