package com.yuhan.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.yuhan.entity.User;
import com.yuhan.service.UserService;

import retrofit2.HttpException;

@Controller
public class PaymentController {
	
	private final IamportClient iamportClient;

    public PaymentController() {
        this.iamportClient = new IamportClient("6760024718016865",
                "4LBcN36qBKgMsxJNhxUSYyxIFnrOO7A90tth8ZpqbI9srNe98abP70WbMN5fHNBAZSFSdhmeelp9h16V");
    }

    @ResponseBody
    @PostMapping("/verify/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(@PathVariable("imp_uid") String imp_uid)
            throws IamportResponseException, IOException {
        return iamportClient.paymentByImpUid(imp_uid);
    }
   
	
}
