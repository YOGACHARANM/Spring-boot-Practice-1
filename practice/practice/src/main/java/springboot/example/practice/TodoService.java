package springboot.example.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public List<Todo> gettodo;
    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
         return  todoRepository.save(todo);
    }

    public Todo getTodoById(Long id){
    return todoRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("todo not found "));

    }

    public List<Todo> getallTodo(){
        return todoRepository.findAll();
    }

    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }
    public void deleteTodo(Todo todo){
        todoRepository.delete(todo);
    }

    public void deleteTodobyId(long id){
        todoRepository.delete(getTodoById(id));
    }

}
