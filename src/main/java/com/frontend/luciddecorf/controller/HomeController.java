package com.frontend.luciddecorf.controller;

import com.frontend.luciddecorf.model.User;
import com.frontend.luciddecorf.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping("/welcome")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return homeService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return homeService.getUser(id);
    }
}
