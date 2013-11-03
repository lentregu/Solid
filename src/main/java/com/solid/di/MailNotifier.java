package com.solid.di;

import com.solid.srp.Mail;
import com.solid.srp.SrpProperties;
import com.solid.srp.User;


public class MailNotifier implements INotificationService{



    @Override
    public void notify(User user,  String subject, String text) {
        Mail.send("admin@solid.com", user.getEmail(), subject, text);
    }


}
