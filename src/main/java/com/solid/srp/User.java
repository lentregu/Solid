package com.solid.srp;

import com.mongodb.BasicDBObject;

public class User extends BasicDBObject{

    public User (){
    }

    public User (String userName, String password, String email, String phone){
        put("userName", userName);
        put("password", password);
        put("email", email);
        put("phone", phone);
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

    public void setPhone(String phone) {
        put("phone", phone);
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

    public String getPhone() {
        return (String) this.get("phone");
    }
}
