package org.example.mybatisdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.mybatisdemo.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user_info")
    List<UserInfo> getUserInfoList();

}
