package org.d05660.jbuilder.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.d05660.jbuilder.entity.User;

public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public User getUserById(@Param("id") Integer id);

    public User queryById(Integer id);
}
