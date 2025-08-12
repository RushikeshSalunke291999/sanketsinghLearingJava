package com.newme.todoapi.service;

import com.newme.todoapi.annotation.TimeMoniter;
import org.springframework.stereotype.Service;

@Service("fakeTodos")
public class fakeTodos implements todoService {
    @TimeMoniter
    @Override
    public String doSometing() {
        for(long i=0;i<=100000000L;i++){}
        return "todos from fakeTodos";
    }
}
