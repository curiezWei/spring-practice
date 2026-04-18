package org.example.mybatisdemo.mapper;

import org.apache.ibatis.annotations.*;
import org.example.mybatisdemo.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {


    @Select("select * from user_info")
    List<UserInfo> getUserInfoList();

    @Select("select * from user_info where delete_flag = #{deleteFlag}")
    UserInfo getUserInfo1(Integer deleteFlag);

    @Select("select * from user_info where delete_flag = #{deleteFlag}")
    List<UserInfo> getUserInfo2(@Param("deleteFlag") Integer deleteFlag);

    @Options(useGeneratedKeys = true , keyProperty = "id")
    @Insert("""
            insert into user_info (username, password, age, gender, phone)
            values (#{username},#{password},#{age},#{gender},#{phone}))
            """)


    Integer insert(UserInfo userInfo);

    @Delete("delete from user_info where id=#{id}")
    Integer delete(Integer id);


}
