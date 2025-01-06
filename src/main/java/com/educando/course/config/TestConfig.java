package com.educando.course.config;

import com.educando.course.entites.User;
import com.educando.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Maria Brown","mariabrow123@hotmail.com",
                "123456789","1234");
        User u2 = new User(null,"carlos silva","carlossilva123@hotmail.com",
                "123456789","1234");

        userRepository.saveAll(Arrays.asList(u1, u2));


    }
}
