package org.example.springmvc1.controller;

import org.example.springmvc1.model.MessageInfo;
import org.example.springmvc1.service.MessageWallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/message")
public class MessageWallController {

    @Autowired
    private MessageWallService messageWallService;

    @RequestMapping("/publish")
    public boolean publish(MessageInfo messageInfo) {
        if(!StringUtils.hasLength(messageInfo.getFrom()) ||
        !StringUtils.hasLength(messageInfo.getTo())||
        !StringUtils.hasLength(messageInfo.getMessage())){
            return false;
        }
        messageWallService.publishMessage(messageInfo);
        return true;
    }

    @RequestMapping("/get")
    public List<MessageInfo> get() {
        return messageWallService.getAllMessage();
    }
}
