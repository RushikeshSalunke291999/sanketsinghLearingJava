package com.newme.todoapi.service;

import org.springframework.stereotype.Service;

@Service("anotherTodos")
public class anotherTodos implements  todoService {
    @Override
    public String doSometing() {
        return "todos from AnotherTodos";
    }
}
