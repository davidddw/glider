package org.jbuilder.glider.service;

import org.jbuilder.glider.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentService {
    @Autowired
    private CommentMapper mapper;

    public CommentMapper getMapper() {
        return mapper;
    }

    public long getSpecifyNewsCommentsCount(int nid) {
        return mapper.getSpecifyNewsCommentsCount(nid);
    }
}
