package com.yuhan.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class PaymentController {
	
	private final IamportClient iamportClient;

    public PaymentController() {
        this.iamportClient = new IamportClient(" ",
                " ");
    }

    @ResponseBody
    @PostMapping("/verify/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(@PathVariable("imp_uid") String imp_uid)
            throws IamportResponseException, IOException {
    	System.out.println("이거 왜 실행 안됨");
        return iamportClient.paymentByImpUid(imp_uid);
    }
   
	
}
