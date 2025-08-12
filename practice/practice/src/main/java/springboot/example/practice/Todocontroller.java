package springboot.example.practice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class Todocontroller {
    @Autowired
    TodoService todoService;


    @PostMapping("/create")
   ResponseEntity< Todo> createuser(@RequestBody Todo todo){
        try{
        Todo created=todoService.createTodo(todo);
        return new ResponseEntity<>(created,HttpStatus.CREATED);
        }catch (RuntimeException exception){
         return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{id}")
    ResponseEntity<Todo> getById(@PathVariable long id ){
        try{
            Todo getid=todoService.getTodoById(id);
            return new ResponseEntity<>(getid,HttpStatus.OK);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    ResponseEntity<List<Todo>> getallid(){
        return new ResponseEntity<List<Todo>>(todoService.getallTodo(),HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<Todo> updateid(@PathVariable long id,@RequestBody Todo todo){
        return new ResponseEntity<Todo>(todoService.updateTodo(todo),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteid(@PathVariable long id){
         todoService.deleteTodobyId(id);
    }
    
}
