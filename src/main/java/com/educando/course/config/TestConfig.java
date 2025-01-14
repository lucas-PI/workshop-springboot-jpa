package com.educando.course.config;

import com.educando.course.entites.Order;
import com.educando.course.entites.User;
import com.educando.course.repositories.OrderRepository;
import com.educando.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Maria Brown","mariabrow123@hotmail.com",
                "123456789","1234");
        User u2 = new User(null,"carlos silva","carlossilva123@hotmail.com",
                "123456789","1234");

        Order or1 = new Order(null, Instant.parse("2019-04-20T19:53:07Z"),u1);
        Order or2 = new Order(null, Instant.parse("2019-06-25T19:53:07Z"),u2);
        Order or3 = new Order(null, Instant.parse("2019-09-20T19:53:07Z"),u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(or1,or2,or3));

    }
}
