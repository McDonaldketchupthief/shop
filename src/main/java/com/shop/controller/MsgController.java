package com.shop.controller;


import com.shop.dto.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MsgController {
    @Autowired
    SimpMessagingTemplate template;


    @RequestMapping("/chat")
    public String chat(Model model) {
        model.addAttribute("center", "chat");
        return "main";

    }

    @RequestMapping("/broadcast")
    public String broadcast(Model model) {
        model.addAttribute("center", "broadcast");
        return "main";

    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("center", "admin");
        return "main";

    }



    @MessageMapping("/receiveall") // 모두에게 전송
    public void receiveall(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
        System.out.println(msg);
        template.convertAndSend("/send",msg);
    }
    @MessageMapping("/receiveme") // 나에게만 전송 ex)Chatbot
    public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
        String id = msg.getSendid();
        template.convertAndSend("/send/"+id,msg);
    }
    @MessageMapping("/receiveto") // 특정 Id에게 전송
    public void receiveto(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
        String id = msg.getSendid();
        String target = msg.getReceiveid();
        template.convertAndSend("/send/to/"+target,msg);
    }
}
