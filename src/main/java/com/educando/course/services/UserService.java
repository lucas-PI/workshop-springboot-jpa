package com.educando.course.services;

import com.educando.course.dto.UserPostRequest;
import com.educando.course.dto.UserPutRequest;
import com.educando.course.entites.User;
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

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(UserPostRequest userPostRequest){
        User obj = User.builder().name(userPostRequest.getName()).phone(userPostRequest.getPhone())
                .email(userPostRequest.getEmail()).password(userPostRequest.getPassword()).build();
        return  repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.delete(findById(id));
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
        }
    public User update(Long id, UserPutRequest userPutRequest) {
        try{User entity = repository.getReferenceById(id);
            updateData(entity,userPutRequest);
            return repository.save(entity);}
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
