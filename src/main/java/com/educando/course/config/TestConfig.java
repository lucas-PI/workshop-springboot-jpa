package com.educando.course.config;

import com.educando.course.entites.Category;
import com.educando.course.entites.Order;
import com.educando.course.entites.Product;
import com.educando.course.entites.User;
import com.educando.course.entites.enums.OrderStatus;
import com.educando.course.repositories.CategoryRepository;
import com.educando.course.repositories.OrderRepository;
import com.educando.course.repositories.ProductRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "electronics");
        Category cat2 = new Category(null, "books");
        Category cat3 = new Category(null, "computers");

        Product p1 = new Product(null,"The Lord of the Ring","jdfjlaksdl",200.0,"");
        Product p2 = new Product(null,"Smart TV","hgsdfjhgjkdsgh",2000.,"");
        Product p3 = new Product(null,"Macbook Pro","dasfsdfsdf",5000.0,"");
        Product p4 = new Product(null,"PC Gamer","srdgsdfgfdg",3000.0,"");
        Product p5 = new Product(null,"Rails for Dummies","dxagfdsf",20.00,"");


        User u1 = new User(null,"Maria Brown","mariabrow123@hotmail.com",
                "123456789","1234");
        User u2 = new User(null,"carlos silva","carlossilva123@hotmail.com",
                "123456789","1234");

        Order or1 = new Order(null, Instant.parse("2019-04-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order or2 = new Order(null, Instant.parse("2019-06-25T19:53:07Z"),OrderStatus.WAITING_PAYMENT,u2);
        Order or3 = new Order(null, Instant.parse("2019-09-20T19:53:07Z"),OrderStatus.DELIVERED,u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(or1,or2,or3));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }
}
