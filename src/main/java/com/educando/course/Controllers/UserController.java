package com.educando.course.Controllers;


import com.educando.course.entites.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "joao","joao123@hotmail.com","85909090","1234");
        return ResponseEntity.ok().body(u);
    }
}
