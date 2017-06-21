package com.kg.ws.web;

import com.kg.ws.domain.WiselyMessage;
import com.kg.ws.domain.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by quanquan on 2017/6/20.
 */
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 广播通信 topic
     *
     * @param message
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("wel: " + message.getName() + "!");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("quanquan")) {
            messagingTemplate.convertAndSendToUser("haha", "/queue/notifications", principal.getName() + "_send:" + msg);
        } else {
            messagingTemplate.convertAndSendToUser("quanquan", "/queue/notifications", principal.getName() + "_send:" + msg);

        }
    }
}
