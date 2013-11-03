package com.solid.di;

import com.solid.srp.User;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMSNotifier implements INotificationService{

    private static final String FROM = "+34668092365";
    @Override
    public void notify(User user, String subject, String text) {
        StringBuffer message = new StringBuffer("from: ").append(FROM).append(", to: ")
                .append(user.getPhone()).append(", subject: ").append(subject).append(", text: ").append(text);

        System.out.println("Sending Message.....: " + message.toString());
    }
}
