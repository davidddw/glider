package org.jbuilder.glider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.jbuilder.glider.entity.News;

public interface NewsMapper {
    
    News getNews(@Param("nid")int nid); 
    
    List<News> getSpecifyCategoryNews(@Param("tid") int tid, RowBounds rowBounds);
    
}
