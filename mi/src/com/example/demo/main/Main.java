package com.example.demo.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.transaction.Transaction;

public class Main {
    public static void main(String[] gst)throws ClassNotFoundException,SQLException,InterruptedException
    {
    	Transaction t = new Transaction();
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\tWelcome to our Ticket booking application!!!");
        Thread.sleep(1500);
        System.out.println("For booking tickets choose 1 or to cancel tickets choose 2 ");
        int n = sc.nextInt();
        if(n==1)
        	  t.st();
        else if(n==2) 
        {
        	System.out.println("Please enter your name: ");
             String nam = sc.next();
             System.out.println("Please enter your email: ");
             String pass = sc.next();
        	t.st(nam,pass);
        }
                 
    }
}