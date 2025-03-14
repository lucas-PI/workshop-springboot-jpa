package com.educando.course.Controllers;


import com.educando.course.dto.UserPostRequest;
import com.educando.course.dto.UserPutRequest;
import com.educando.course.entites.User;
import com.educando.course.services.UserService;
import com.educando.course.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Log4j2
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private DateUtil dataUtil;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<User>> findByName(@RequestParam String name){
        List<User> listByName = service.findByName(name);
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok().body(listByName);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserPostRequest userPostRequest){
        User user = service.insert(userPostRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserPutRequest userPutRequest){
        User obj = service.update(id, userPutRequest);
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(obj);
    }
}
