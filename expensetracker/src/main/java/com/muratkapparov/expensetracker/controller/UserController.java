package com.muratkapparov.expensetracker.controller;
import com.muratkapparov.expensetracker.entity.User;
import com.muratkapparov.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/profile")
    public ResponseEntity<User> get(){
        return new ResponseEntity<User>(userService.read(), HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<User> update(@RequestBody User user){
        User mUser = userService.update(user);
        return new ResponseEntity<>(mUser, HttpStatus.OK);
    }

    @DeleteMapping("/profile")
    public ResponseEntity<HttpStatus> delete(){
        userService.delete();
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
