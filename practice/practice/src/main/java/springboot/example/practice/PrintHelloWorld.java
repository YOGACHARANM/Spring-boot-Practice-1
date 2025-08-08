package springboot.example.practice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class PrintHelloWorld {
        @GetMapping("/hello")
        String HelloWorld(){
            return "welcome to thailand" ;
        }

    }

