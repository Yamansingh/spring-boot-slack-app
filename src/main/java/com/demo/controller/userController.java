package com.demo.controller;

import com.demo.model.User;
import com.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class userController {
    @Autowired
    private userService userService;
    //http://localhost:8089/saveUser
    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUserHandler(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }
    //http://localhost:8089/getUsers
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUserDetails(){
        List<User> Users = userService.getAllUser();
        return new ResponseEntity<List<User>>(Users,HttpStatus.OK);
    }
    //http://localhost:8089/getUser/5
    @GetMapping("/getUser/{Id}")
    public Optional<User> getUserByIdHandller(@PathVariable("Id") Integer Id){
        return userService.getUserById(Id);
    }


    //http://localhost:8089/deleteUser/4
    @DeleteMapping("/deleteUser/{Id}")
    public User deleteUserByIdHandller(@PathVariable("Id") Integer Id){
        return userService.deleteUserById(Id);
    }
    //http://localhost:8089/User/6?userName=ravi
    @PutMapping("/User/{userId}")
    public ResponseEntity<User> updateUserName(@PathVariable("userId") Integer userId, @RequestParam("userName") String userName){
        User updatedUser = userService.updateUserName(userId,userName);
        return new ResponseEntity<User>(updatedUser,HttpStatus.ACCEPTED);
    }






}
