package com.solid.di;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMSService {

    public static void send(String from, String to, String subject, String text){

        StringBuffer message = new StringBuffer("from: ").append(from).append(", to: ")
                .append(to).append(", subject: ").append(subject).append(", text: ").append(text);

        System.out.println("Sending Message.....: " + message.toString());
    }

}
