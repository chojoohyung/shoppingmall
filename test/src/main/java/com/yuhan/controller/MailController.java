package com.yuhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuhan.service.MailService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MailController {
	
	private final MailService mailService;

    @ResponseBody
    @PostMapping("/mail")
    public String MailSend(String mail){
    	System.out.println("인증메시지 옴");

        int number = mailService.sendMail(mail);

        String num = "" + number;

        return num;
    }
	
}
