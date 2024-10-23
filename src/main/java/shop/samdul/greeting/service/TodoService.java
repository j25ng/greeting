package shop.samdul.greeting.service;

import shop.samdul.greeting.entity.TodoEntity;
import shop.samdul.greeting.mapper.TodoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoMapper todoMapper;

    public List<TodoEntity> getTodos() {
        System.out.println("[service] findAll");
        List<TodoEntity> todos = todoMapper.findAll();
        System.out.println("[todos]:" + todos.size());
        return todos;
    }

    // 특정 ID로 Todo 항목 조회
    public TodoEntity findById(Integer id) {
        System.out.println("[service] findById - ID: " + id);
        TodoEntity todo = todoMapper.findById(id);
        System.out.println("[todo] found: " + (todo != null ? "Yes" : "No"));
        return todo;
    }

    // 새로운 Todo 항목 생성
    public TodoEntity createTodo(TodoEntity todo) {
        System.out.println("[service] createTodo - Subject: " + todo.getSubject());
        int result = todoMapper.createTodo(todo);
        if (result > 0) {
            System.out.println("[createTodo] success - ID: " + todo.getId());
            return todo;
        } else {
            System.out.println("[createTodo] failed");
            return null;
        }
    }

    // Todo 항목 업데이트
    public TodoEntity updateTodo(Integer id, TodoEntity todo) {
        System.out.println("[service] updateTodo - ID: " + id);
        todo.setId(id); // ID 설정
        int result = todoMapper.updateTodo(todo); // id를 매개변수로 넘길 필요 없음
        if (result > 0) {
            System.out.println("[updateTodo] success");
            return todo;
        } else {
            System.out.println("[updateTodo] failed");
            return null;
        }
    }

    // Todo 항목 삭제
    public boolean deleteTodo(Integer id) {
        System.out.println("[service] deleteTodo - ID: " + id);
        int result = todoMapper.deleteTodo(id);
        if (result > 0) {
            System.out.println("[deleteTodo] success");
            return true;
        } else {
            System.out.println("[deleteTodo] failed");
            return false;
        }
    }
}