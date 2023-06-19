package com.project.todo.controller;

import com.project.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view")
public class ViewController {

    private final TodoService todoService;

    @GetMapping("/todolist")
    public String getTodoList(Model model, Principal principal) {
        model.addAttribute("todoList", todoService.getTodos(principal));
        model.addAttribute("user", principal);
        return "/todolist";
    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/signup")
    public String SignUp() {
        return "signup";
    }

}
