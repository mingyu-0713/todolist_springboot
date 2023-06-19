package com.project.todo.controller;

import com.project.todo.dto.SignUpDto;
import com.project.todo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public String signUp(SignUpDto dto) {
        memberService.signUp(dto);
        return "login";
    }

}
