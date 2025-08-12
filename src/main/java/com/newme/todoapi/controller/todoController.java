package com.newme.todoapi.controller;

import com.newme.todoapi.entity.Todo;
import com.newme.todoapi.service.todoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class todoController {


    private final todoService todoService1;

    private final todoService todoService2;


    private static List<Todo> todoList;

    private static String TO_DO_NOT_FOUND = "Todo not found";


    public todoController(@Qualifier("fakeTodos") todoService todoService,
                          @Qualifier("anotherTodos") todoService todoService2) {
        this.todoService1 = todoService;
        this.todoService2 = todoService2;
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, true, "todo 1", 101));
        todoList.add(new Todo(2, false, "todo 2", 102));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false) Boolean completed) {
        System.out.println("incoming Query params: " + completed + " \n" + this.todoService1.doSometing()+" \n"+this.todoService2.doSometing());
        return ResponseEntity.ok(todoList);
    }
}
