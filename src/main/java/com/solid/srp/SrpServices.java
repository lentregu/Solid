package com.solid.srp;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class SrpServices {

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


    public SrpServices() {
         users = new UserDB(db);
    }

    public void signUp(String userName, String password, String email){
        User user = new User(userName, password, email);
        users.insert(user);
    }

    public User readUser(String userName){
        return users.findByUserName(userName);
    }

}
