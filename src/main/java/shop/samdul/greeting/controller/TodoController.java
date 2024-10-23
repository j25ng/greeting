package shop.samdul.greeting.controller;

import shop.samdul.greeting.entity.TodoEntity;
import shop.samdul.greeting.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public List<TodoEntity> list() {
        System.out.println("[Controller]");
        List<TodoEntity> r = todoService.getTodos();
        return r;
    }

    @GetMapping("/todos/{id}")
    public TodoEntity find(@PathVariable Integer id) {
        TodoEntity r = todoService.findById(id);
        return r;
    }

    @PostMapping("/todos")
    public TodoEntity create(@RequestBody TodoEntity todo) {
        System.out.println("[Controller] Create new todo");
        TodoEntity r = todoService.createTodo(todo);
        return r;
    }

    @PutMapping("/todos/{id}")
    public TodoEntity update(@PathVariable Integer id, @RequestBody TodoEntity todo) {
        System.out.println("[Controller] Update todo with ID: " + id);
        TodoEntity r = todoService.updateTodo(id, todo);
        return r;
    }

    @DeleteMapping("/todos/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("[Controller] Delete todo with ID: " + id);
        boolean success = todoService.deleteTodo(id);
        if (success) {
            return "Todo deleted successfully";
        } else {
            return "Todo deletion failed";
        }
    }
}
