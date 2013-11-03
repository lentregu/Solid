package com.solid.di;

import com.solid.srp.User;

public interface INotificationService {

    void notify(User user, String subject, String text);
}
