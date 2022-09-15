package com.demo.service;

import com.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface userService {
    public User saveUser(User user);
    public List<User> getAllUser();
    public Optional<User> getUserById(Integer userId);
    public User deleteUserById(Integer userId);
    public User updateUserName(Integer userId, String userName);

}
