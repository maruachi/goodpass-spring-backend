package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminUserRequestMailService {
    @Value("${app.email}")
    private String masterEmail;
    private final JavaMailSender mailSender;

    public boolean sendUserRequestMail(AdminUserRequestDto adminUserRequestDto) {
        String mailBody = adminUserRequestDto.toString();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(masterEmail);
        mailMessage.setSubject("굿패스 가입 신청서");
        mailMessage.setText(mailBody);

        try {
            mailSender.send(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
