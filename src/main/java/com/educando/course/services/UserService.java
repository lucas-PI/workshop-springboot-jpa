package com.educando.course.services;

import com.educando.course.dto.UserPostRequest;
import com.educando.course.dto.UserPutRequest;
import com.educando.course.entites.User;
import com.educando.course.mapper.UserMapper;
import com.educando.course.repositories.UserRepository;
import com.educando.course.services.exception.DatabaseException;
import com.educando.course.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

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
