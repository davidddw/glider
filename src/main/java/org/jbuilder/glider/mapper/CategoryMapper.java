package org.jbuilder.glider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jbuilder.glider.entity.Category;

public interface CategoryMapper {
    List<Category> getTypes(@Param("tid")int startTid, @Param("tid")int count);
}
