package com.example.capstone2.Controller;

import com.example.capstone2.Api.Api;
import com.example.capstone2.Model.User;
import com.example.capstone2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    Logger logger= LoggerFactory.getLogger(UserController.class);
    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user){
        logger.info("inside add user");

        userService.addUser(user);
        return ResponseEntity.ok().body(new Api("User Added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user){
        logger.info("inside Update User");
        userService.updateUser(id,user);
        return ResponseEntity.ok().body(new Api("User updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        logger.info("inside Delete user");
        userService.deleteUser(id);
        return ResponseEntity.ok().body(new Api("User deleted"));

    }
    @GetMapping("/get-by-name/{name}")
    public ResponseEntity getUserByName(@PathVariable String name){
        logger.info("inside get username");
        User user = userService.getUserByName(name);
        return ResponseEntity.ok().body(user);
    }
}
