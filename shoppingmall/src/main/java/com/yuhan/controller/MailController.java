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
    @PostMapping("mail")
    public String MailSend(String mail){
    	
        int number = mailService.sendMail(mail);

        String num = "" + number;
        System.out.println("mail number : "+number);
        return num;
    }
	
}
