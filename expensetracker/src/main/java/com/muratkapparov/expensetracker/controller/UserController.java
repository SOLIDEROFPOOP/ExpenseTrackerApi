package com.muratkapparov.expensetracker.controller;

import com.muratkapparov.expensetracker.entity.User;
import com.muratkapparov.expensetracker.entity.UserModel;
import com.muratkapparov.expensetracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user){
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> get(@PathVariable Long id){
        return new ResponseEntity<User>(userService.read(id), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@PathVariable Long id , @RequestBody User user){
        User mUser = userService.update(user, id);
        return new ResponseEntity<>(mUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
