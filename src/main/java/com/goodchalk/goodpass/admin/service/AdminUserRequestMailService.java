package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminUserRequestMailService {
    public static final String TARGET_EMAIL = "good.chalk22@gmail.com";
    public static final String EMAIL_SUBJECT = "굿패스 가입 신청서";
    private final JavaMailSender mailSender;

    public boolean sendUserRequestMail(AdminUserRequestDto adminUserRequestDto) {
        String mailBody = adminUserRequestDto.toString();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(TARGET_EMAIL);
        mailMessage.setSubject(EMAIL_SUBJECT);
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
