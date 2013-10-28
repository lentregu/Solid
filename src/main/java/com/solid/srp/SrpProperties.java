package com.solid.srp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum SrpProperties {
    INSTANCE;

    private Properties properties;

    private SrpProperties() {
        this.properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("com/solid/srp/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SrpProperties getInstance() {
        return INSTANCE;
    }


    public String getDbHost() {
        return String.valueOf(properties.get("db.host"));
    }

    public int getDbPort() {

        return Integer.parseInt(String.valueOf(properties.get("db.port")));
    }

    public String getDbName() {
        return String.valueOf(properties.get("db.name"));
    }

    public String getSmtpUsername() {
        return String.valueOf(properties.get("mail.smtp.username"));
    }

    public String getSmtpPassword() {
        return String.valueOf(properties.get("mail.smtp.password"));
    }

    public String getSmtpSocketFactortyPort() {
        return String.valueOf(properties.get("mail.smtp.socketFactory.port"));
    }

    public String getSmtpSocketFactortyClass() {
        return String.valueOf(properties.get("mail.smtp.socketFactory.class"));
    }

    public String getMailSmtpHost() {
        return String.valueOf(properties.get("mail.smtp.host"));
    }

    public String getMailSmtpPort() {
        return String.valueOf(properties.get("mail.smtp.port"));
    }

    public Object get(String name) {
        return properties.get(name);
    }


}
