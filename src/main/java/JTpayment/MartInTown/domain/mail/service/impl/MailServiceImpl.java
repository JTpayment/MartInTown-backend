package JTpayment.MartInTown.domain.mail.service.impl;

import JTpayment.MartInTown.domain.mail.service.MailService;
import JTpayment.MartInTown.global.util.RedisUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    @Value("${email.username}")
    private String username;
    private final JavaMailSender javaMailSender;
    private final RedisUtil redisUtil;
    private int Num;

    public void RandomNum(){
        Random n = new Random();
        StringBuilder rn = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            rn.append(n.nextInt(10));
        }
        Num = Integer.parseInt(rn.toString());
    }

    @Override
    public String execute(String email) {
        RandomNum();
        String setForm = username;
        String toMail = email;
        String title = "MartInTown 가입 인증번호입니다.";
        String content = "인증번호는 " + Num + "입니다.";

        mailSend(setForm,toMail,title,content);
        return Integer.toString(Num);
    }

    public void mailSend(String setFrom, String toMail, String title, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");

            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        redisUtil.setDataExpire(Integer.toString(Num),toMail,60*5L);

    }
}
