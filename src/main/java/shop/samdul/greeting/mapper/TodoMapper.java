package shop.samdul.greeting.mapper;

import shop.samdul.greeting.entity.TodoEntity;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
    public List<TodoEntity> findAll();
}
