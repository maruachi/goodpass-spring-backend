package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.domain.AdminUser;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@EnableAsync
@Service
public class AdminUserJoinMailService {
    private final JavaMailSender mailSender;

    public void send(AdminUser adminUser, String temporaryPassword) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(adminUser.getEmailAddress());

        mailMessage.setSubject("굿패스 서비스 이용 가입되셨습니다. (임시 비밀번호 포함)");
        String name = adminUser.getName();
        String message = name + "님의 굿패스 서비스 계정이 생성되었습니다." + '\n' +
                "아이디=" + adminUser.getUsername() + '\n' +
                "임시비밀번호=" + temporaryPassword;
        mailMessage.setText(message);

        try {
            mailSender.send(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
