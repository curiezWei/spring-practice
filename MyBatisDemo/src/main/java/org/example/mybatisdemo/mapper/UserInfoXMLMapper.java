package org.example.mybatisdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatisdemo.model.UserInfo;

@Mapper
public interface UserInfoXMLMapper {
    Integer insert(UserInfo userInfo);

    Integer insertComplex(UserInfo userInfo);
}
