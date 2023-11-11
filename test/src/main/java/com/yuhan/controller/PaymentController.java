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
                "L9p2wZncSXO8pHLKkEMrkRrtusCliZ5uYWC8XIet4p9lUCtQXjkluSZNcC4zb6JDkTBXg3SU8uWKN3o3");
    }

    @ResponseBody
    @PostMapping("/verify/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(@PathVariable("imp_uid") String imp_uid)
            throws IamportResponseException, IOException {
        return iamportClient.paymentByImpUid(imp_uid);
    }
   
	
}
