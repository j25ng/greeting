package shop.samdul.greeting.mapper;

import shop.samdul.greeting.entity.TodoEntity;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
    List<TodoEntity> findAll();

    TodoEntity findById(Integer id);

    Integer createTodo(TodoEntity todo);

    Integer updateTodo(TodoEntity todo);

    Integer deleteTodo(Integer id);
}