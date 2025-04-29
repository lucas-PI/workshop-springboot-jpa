package com.educando.course.Controllers;


import com.educando.course.dto.user.UserPostRequest;
import com.educando.course.dto.user.UserPutRequest;
import com.educando.course.entites.User;
import com.educando.course.services.UserService;
import com.educando.course.util.DateUtil;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<User>> findAll(Pageable pageable){
        Page<User> pageList = service.findAll(pageable);
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok().body(pageList);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping(path = "/find")
    public ResponseEntity<Page<User>> findByName(Pageable pageable,@RequestParam String name){
        Page<User> pageListByName = service.findByName(pageable, name);
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok().body(pageListByName);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody @Valid UserPostRequest userPostRequest){
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
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid UserPutRequest userPutRequest){
        User obj = service.update(id, userPutRequest);
        log.info(dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(obj);
    }
}
