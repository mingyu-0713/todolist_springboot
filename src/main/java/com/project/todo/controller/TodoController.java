package com.project.todo.controller;

import com.project.todo.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo/del")
    public String delTodo(@RequestParam Long id, Principal principal) {
        todoService.delTodo(id, principal);
        return "redirect:/view/todolist";
    }

    @PostMapping("/todoWrite")
    public String todoWrite(HttpServletRequest request, Principal principal) {
        todoService.addTodo(request.getParameter("memo"), principal);
        return "redirect:/view/todolist";
    }


}

