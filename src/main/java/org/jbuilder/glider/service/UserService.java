package org.jbuilder.glider.service;

import org.jbuilder.glider.entity.User;
import org.jbuilder.glider.mapper.UserMapper;
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
