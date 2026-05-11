package org.example.managebook.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.managebook.model.UserInfo;

@Mapper
public interface UserInfoMapper {
    @Select("""
            select id, user_name,`password`, delete_flag, create_time,update_time
            from user_info where delete_flag=0 and user_name=#{name}
"""
            )
    UserInfo queryUserByName(String name);


}
