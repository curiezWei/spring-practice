package org.example.springmvc1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springmvc1.model.MessageInfo;

import java.util.List;

@Mapper
public interface MessageInfoMapper {

    @Select("""
select `from`, `to`, `message` from message_info where delete_flag=0
""")
    List<MessageInfo> getAllMessage();

    @Insert("""
insert into message_info (`from`,`to`, `message`) values(#{from},#{to},#{message}
""")
    Integer publishMessage(MessageInfo messageInfo);
}
