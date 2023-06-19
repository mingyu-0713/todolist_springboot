package com.project.todo.service;

import com.project.todo.dto.MemberLoginDto;
import com.project.todo.dto.SignUpDto;
import com.project.todo.entity.member.Member;
import com.project.todo.entity.member.Role;
import com.project.todo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUpDto dto) {
        memberRepository.save(
                Member.builder()
                        .username(dto.getUsername())
                        .password(passwordEncoder.encode(dto.getPassword()))
                        .role(Role.USER.getKey())
                        .build()
        );
    }

}
