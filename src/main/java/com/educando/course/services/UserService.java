package com.educando.course.services;

import com.educando.course.dto.user.UserPostRequest;
import com.educando.course.dto.user.UserPutRequest;
import com.educando.course.entites.User;
import com.educando.course.mapper.UserMapper;
import com.educando.course.repositories.UserRepository;
import com.educando.course.services.exception.DatabaseException;
import com.educando.course.services.exception.ResourceByNameNotFound;
import com.educando.course.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper userMapper;

    public Page<User> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Page<User> findByName(Pageable pageable,String name){
        try {
            List<User> list = repository.findByNameIgnoreCase(name);
            if(list.isEmpty()){throw new RuntimeException();}
            return repository.findByNameContainingIgnoreCase(name, pageable);
        }catch(RuntimeException e){
            throw new ResourceByNameNotFound(name);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public User insert(UserPostRequest userPostRequest){
        return  repository.save(userMapper.toUser(userPostRequest));
    }

    public void delete(Long id) {
        try {
            repository.delete(findById(id));
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
        }
    public User update(Long id, UserPutRequest userPutRequest) {
        try{User userSaved = repository.getReferenceById(id);
            User user = userMapper.toUser(userPutRequest);
            user.setId(userSaved.getId());
            return repository.save(user);}
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, UserPutRequest userPutRequest) {
        entity.setName(userPutRequest.getName());
        entity.setEmail(userPutRequest.getEmail());
        entity.setPhone(userPutRequest.getPhone());
    }
}
