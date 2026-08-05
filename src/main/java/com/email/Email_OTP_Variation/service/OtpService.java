package com.email.Email_OTP_Variation.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class OtpService {

	@Autowired
	private JavaMailSender javaMailSendFer;

	private String otp;

	public String generateOtp() {

		Random random = new Random();
		otp = String.format("%06d", random.nextInt(999999));
		return otp;
	}

	public void SendOTP(String toEmail) {
		String otpcode = generateOtp();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("your otp code");
		message.setText("Your OTP is: " + otpcode);
		javaMailSendFer.send(message);
	}
	
	public boolean validation(String inputOtp) {
	    return otp != null && otp.equals(inputOtp);
	}


}
