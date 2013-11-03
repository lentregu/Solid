package com.solid.srp;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserDBTest {

    private static final String hostnameTest="127.0.0.1";
    private static final int portTest=27017;
    private static final String dbTest = "sol-users-test";


    private UserDB usersTest;
    private DBCollection users;

    @Before
    public void setUp() throws UnknownHostException {
       MongoClient mongo = new MongoClient(hostnameTest, portTest);
       usersTest = new UserDB(mongo.getDB(dbTest));
    }

    @Test
    public void insertUserIntoDBCreateADocWithANewId() {
        User user = new User("Pepe", "pepe_password","pepe_mail@pepe.com","+34652587893");
        usersTest.insert(user);
        assertNotNull(user.get("_id"));
    }

    @Test (expected = NullPointerException.class)
    public void insertNullUserThrowsNullPointerException(){
        usersTest.insert(null);
    }

    @Test
    public void retrieveUserFromDB(){
        User user = new User("Pepe", "pepe_password","pepe_mail@pepe.com", "+34652587893");
        usersTest.insert(user);
        User user2 = usersTest.findByUserName(user.getUserName());
        assertEquals(user.getUserName(), user2.getUserName());
        assertEquals(user.getPassword(), user2.getPassword());
        assertEquals(user.getEmail(), user2.getEmail());
        assertEquals(user.getPhone(), user2.getPhone());
    }

    @After
    public void tearDown(){
        usersTest.drop();
    }

}
