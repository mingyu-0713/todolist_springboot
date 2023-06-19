package com.project.todo.repository;

import com.project.todo.entity.todo.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todolist, Long> {

}
