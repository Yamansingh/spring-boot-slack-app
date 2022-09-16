package com.demo.model;

import com.demo.repository.userDao;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class UserDataFetcher {
    @Autowired
    userDao userDao;

    @DgsQuery(field = "users")
    public List<User> customers() {
        return userDao.findAll();
    }


}
