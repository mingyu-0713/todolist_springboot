package com.project.todo.service;

import com.project.todo.entity.member.Member;
import com.project.todo.entity.todo.Todolist;
import com.project.todo.repository.MemberRepository;
import com.project.todo.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Todolist> getTodos(Principal principal) {
        return memberRepository.findByUsername(principal.getName()).get().getTodos();
    }

    @Transactional
    public void addTodo(String todoName, Principal principal) {
        if (todoName.length() > 0) {
            Member member = memberRepository.findByUsername(principal.getName()).get();
            Todolist todo = Todolist.builder()
                    .todo_memo(todoName)
                    .build();

            todoRepository.save(todo);

            member.getTodos().add(todo);
        }
    }

    @Transactional
    public void delTodo(Long id, Principal principal) {
        Member member = memberRepository.findByUsername(principal.getName()).get();
        Todolist todo = todoRepository.findById(id).get();

        member.getTodos().remove(todo);

        todoRepository.deleteById(id);
    }

}
