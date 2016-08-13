package org.jbuilder.glider.service;

import org.jbuilder.glider.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryService {
    @Autowired
    private CategoryMapper mapper;

    public CategoryMapper getMapper() {
        return mapper;
    }

//    public User getUserById(Integer userId) {
//        // return mapper.getUserById(userId);
//        return mapper.queryById(userId);
//    }
}
