package shop.samdul.greeting.controller;

import shop.samdul.greeting.entity.TodoEntity;
import shop.samdul.greeting.sevice.TodoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    TodoService todoService;

    @GetMapping("/list")
    public List<TodoEntity> list() {
        System.out.println("[Controller]");
        List<TodoEntity> r = todoService.getTodos();
        return r;
    }
}
