package com.solid.srp;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

    private static SrpProperties srpProperties = SrpProperties.INSTANCE;

    private static Session session =  Session.getInstance(loadMailProperties(),
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(srpProperties.getSmtpUsername(),
                            srpProperties.getSmtpPassword());
                }
            });


    public static void send(String from, String to, String subject, String text){

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

            System.out.println("Sent....");

        }
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    private static Properties loadMailProperties() {


        Properties mailProp = new Properties();

        mailProp.put("mail.smtp.host", srpProperties.getMailSmtpHost());
        mailProp.put("mail.smtp.socketFactory.port", srpProperties.getSmtpSocketFactortyPort());
        mailProp.put("mail.smtp.socketFactory.class", srpProperties.getSmtpSocketFactortyClass());
        mailProp.put("mail.smtp.auth", "true");
        mailProp.put("mail.smtp.port", srpProperties.getMailSmtpPort());

        return mailProp;
    }


}
