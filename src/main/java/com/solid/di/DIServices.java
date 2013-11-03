package com.solid.di;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.solid.srp.SrpProperties;
import com.solid.srp.User;
import com.solid.srp.UserDB;

import java.net.UnknownHostException;

public class DIServices {

    private static UserDB users;

    private static DB db;

    private static SrpProperties srpProperties = SrpProperties.INSTANCE;

    static {

        try {
            MongoClient mongo = new MongoClient(srpProperties.getDbHost(), srpProperties.getDbPort());
            db = mongo.getDB(srpProperties.getDbName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }


    public DIServices() {
         users = new UserDB(db);
    }

    public void signUp(String userName, String password, String email, String phone){
        User user = new User(userName, password, email, phone);
        users.insert(user);
        //This design violates the dependency inversion principle.
        //The high level module DIServices depends on MailService which is a concrete class and not an abstraction.
        MailService.send("admin@solid.com", email, "Solid Registration", "Welcome to Solid Principles!!");
    }

    public User readUser(String userName){
        return users.findByUserName(userName);
    }

}
