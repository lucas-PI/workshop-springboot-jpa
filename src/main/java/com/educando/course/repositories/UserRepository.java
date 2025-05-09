package com.educando.course.repositories;

import com.educando.course.entites.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByNameIgnoreCase(String name);
    Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
