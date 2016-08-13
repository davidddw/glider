package org.jbuilder.glider.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jbuilder.glider.entity.User;

public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public User getUserById(@Param("id") Integer id);

    public User queryById(Integer id);
}
