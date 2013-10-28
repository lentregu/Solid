package com.solid.srp;

import com.mongodb.BasicDBObject;

public class User extends BasicDBObject{

    public User (){
    }

    public User (String userName, String password, String email){
        put("userName", userName);
        put("password", password);
        put("email", email);
    }

    public void setUserName(String userName) {
        put("userName", userName);
    }

    public void setPassword(String password) {
        put("password", password);
    }

    public void setEmail(String email) {
        put("email", email);
    }

    public String getUserName() {
        return (String) this.get("userName");
    }

    public String getPassword() {
        return (String) this.get("password");
    }
    public String getEmail() {
        return (String) this.get("email");
    }
}
