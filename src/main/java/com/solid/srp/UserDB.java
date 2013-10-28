package com.solid.srp;


import com.mongodb.*;

import java.net.UnknownHostException;

public class UserDB {

    private String host;
    private String port;
    private DBCollection users;


    public UserDB(DB db) {
        users = db.getCollection("users");
        users.setObjectClass(User.class);
    }

    public void insert (User user) throws NullPointerException{
        if (user == null) {
            throw new NullPointerException("User can't be null");
        }
        users.insert(user);
    }

    public void drop () throws NullPointerException{
        users.drop();
    }

    public User findByUserName(String userName) {
        User criteria = new User();
        criteria.setUserName(userName);
        return (User) users.findOne(criteria);

    }

    public User findByAnyField(String field, String fieldValue) {
        BasicDBObject criteria = new BasicDBObject();
        criteria.put(field, fieldValue);
        return (User) users.findOne(criteria);

    }
}
