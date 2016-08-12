package org.d05660.jbuilder.service;

import org.d05660.jbuilder.entity.User;
import org.d05660.jbuilder.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    @Autowired
    private UserMapper mapper;

    public UserMapper getMapper() {
        return mapper;
    }

    public User getUserById(Integer userId) {
        // return mapper.getUserById(userId);
        return mapper.queryById(userId);
    }
}
