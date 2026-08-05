package com.email.Email_OTP_Variation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.Email_OTP_Variation.service.OtpService;

@RestController
@RequestMapping("/otp")
public class OTP_Controller {

	@Autowired
	private OtpService otpService;

	@PostMapping("/{email}")
	public String SendOTP(@PathVariable String email) {
		otpService.SendOTP(email);
		return " OTP sent to ur " + email;
	}
	
	@PostMapping("/verify/{otp}")
	public String verifyOtp(@PathVariable String otp) {
	    boolean isValid = otpService.validation(otp);
	    return isValid ? "OTP verified successfully!" : "Invalid OTP!";
	}


}
