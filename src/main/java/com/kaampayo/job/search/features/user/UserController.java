package com.kaampayo.job.search.features.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/user")
    private List<User> getAllUser()
    {
        return userService.getAllUser();
    }
    @GetMapping("/user/{id}")
    private User getUser(@PathVariable("id") int id)
    {
        return userService.getUserById(id);
    }
    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") int id)
    {
        userService.delete(id);
    }
    @PostMapping("/user")
    private int saveUser(@RequestBody User user)
    {
        userService.saveOrUpdate(user);
        return user.getId();
    }
}