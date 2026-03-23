package org.example.springmvc1;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/message")
public class MessageWallController {
    private List<MessageInfo> messageInfos = new ArrayList<>();

    @RequestMapping("/publish")
    public boolean publish(MessageInfo messageInfo) {
        if(!StringUtils.hasLength(messageInfo.getFrom()) ||
        !StringUtils.hasLength(messageInfo.getTo())||
        !StringUtils.hasLength(messageInfo.getSay())){
            return false;
        }
        messageInfos.add(messageInfo);
        return true;
    }

    @RequestMapping("/get")
    public List<MessageInfo> get() {
        return messageInfos;
    }
}
