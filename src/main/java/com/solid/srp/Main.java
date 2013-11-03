package com.solid.srp;

//import org.slf4j.Logger;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
    private static Logger logger = Logger.getLogger(Main.class.getName());

    private static BufferedReader keypad=null;

    private SrpServices srpServices = new SrpServices();

    static
    {
        keypad = new BufferedReader(new InputStreamReader(System.in));
    }


    private static String readKeypad(String element)
    {
        String valor=null;
        System.out.print(element + ": ");
        try
        {
            valor = keypad.readLine();
        }
        catch (IOException ex)
        {
            logger.log(Level.SEVERE,"Error reading element: " + element);
        }

        return valor;
    }

    private void insertUser(){
        String userName = readKeypad("User Name: ");
        String password = readKeypad("Password: ");
        String email = readKeypad("Email: ");
        String phone = readKeypad("Phone: ");
        srpServices.signUp(userName, password, email, phone);
    }

    private void readUser(){
        String userName = readKeypad("User Name: ");
        User user = srpServices.readUser(userName);
        System.out.println("User Name: " + user.get("userName"));
        System.out.println("Password: " + user.get("password"));
        System.out.println("Email: " + user.get("email"));
        System.out.println("Phone: " + user.get("phone"));
    }


    public static void main(String args[])
    {
        Main test = new Main();

        SrpServices signUpService = new SrpServices();

        int option;
        do
        {
            System.out.println("1. Insert User");
            System.out.println("2. Read User");
            System.out.println("3. Exit");
            option = Integer.valueOf(readKeypad("Select an option ")).intValue();

            switch(option)
            {
                case 1:
                {
                    test.insertUser();
                    break;
                }
                case 2:
                {
                    test.readUser();
                    break;
                }
                case 3:
                {
                    System.out.print("Exit");
                    break;
                }
                default:
                {
                    System.out.print("Unavailable option");
                    break;
                }
            }

        } while (option !=3);


    }


}
