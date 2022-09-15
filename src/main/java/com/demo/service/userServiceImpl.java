package com.demo.service;

import com.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements userService{
    @Autowired
    private com.demo.repository.userDao userDao;





    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers = userDao.findAll();
        return allUsers;
    }

    @Override
    public Optional<User> getUserById(Integer userId) {
        Optional<User> user = userDao.findById(userId);
        if(user.isPresent()){
            return user;
        }
        else{
            return null;
        }

    }

    @Override
    public User deleteUserById(Integer userId) {
        User existingUser = userDao.findById(userId).orElseThrow();
        userDao.delete(existingUser);
        return existingUser;



    }

    @Override
    public User updateUserName(Integer userId, String userName) {
        Optional<User> opt = userDao.findById(userId);
        if(opt.isPresent()){
            User existingUser = opt.get();
            existingUser.setUserName(userName);
            return userDao.save(existingUser);
        }
        return null;
    }




}
