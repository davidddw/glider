package org.jbuilder.glider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jbuilder.glider.entity.Comment;

public interface CommentMapper {
    
    List<Comment> getComments(@Param("id") int nid, @Param("id") int startCid, @Param("id") int count);

    void addComment(@Param("id") int nid, @Param("id") String ptime, @Param("id") String region,
            @Param("id") String content);
    
    long getSpecifyNewsCommentsCount(@Param("nid") int nid);
}
