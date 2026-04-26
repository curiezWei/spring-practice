package org.example.springmvc1.service;

import org.example.springmvc1.mapper.MessageInfoMapper;
import org.example.springmvc1.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageWallService {
    @Autowired
    private MessageInfoMapper messageInfoMapper;

    public List<MessageInfo> getAllMessage() {
        return messageInfoMapper.getAllMessage();
    }

    public Integer publishMessage(MessageInfo messageInfo) {
        return messageInfoMapper.publishMessage(messageInfo);
    }
}
