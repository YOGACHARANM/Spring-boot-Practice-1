package springboot.example.practice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todo")
public class Todocontroller {
    @Autowired
    TodoService todoService;


    @PostMapping("/create")
   ResponseEntity< Todo> createuser(@RequestBody Todo todo){
      return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }
    
}
