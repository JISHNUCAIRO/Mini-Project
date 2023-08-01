package com.example.demo.transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface A
{
  void st()throws ClassNotFoundException,SQLException,InterruptedException;	
}

abstract class I
{
	public abstract void ask(int c,int c1,int c2,int c3,String[] arr,int price1,int price2,int price3,int price4,String name)throws InterruptedException;
}
class B extends I
{
	 public void ask(int c,int c1,int c2,int c3,String[] arr,int price1,int price2,int price3,int price4,String name) throws InterruptedException{
		System.out.println("Welcome "+name+"!!");
       			Thread.sleep(1500);  
        System.out.println("These are the types of tickets available with their price and availability of seats:");
  System.out.println();
  Thread.sleep(1000);
         System.out.println("\tTicket type: "+arr[0]+" ,Price: "+price1+" ,Seat available: "+c);
         Thread.sleep(1000);
         System.out.println("\tTicket type: "+arr[1]+" ,Price: "+price2+" ,Seat available: "+c1); 
         Thread.sleep(1000);
         System.out.println("\tTicket type: "+arr[2]+" ,Price: "+price3+" ,Seat available: "+c2);
         Thread.sleep(1000);
         System.out.println("\tTicket type: "+arr[3]+" ,Price: "+price4+" ,Seat available: "+c3);
         int c9=c+c1+c2+c3;
     
     }
}
public class Transaction extends B implements A{
    public void st()throws ClassNotFoundException,SQLException,InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
        Thread.sleep(1500);
        System.out.println("Please enter your email:");
        String email = sc.nextLine();
        String regex = "[A-Za-z0-9]+@gmail\\.com";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        while(true)
        {
            if(!matcher.matches())
            {
                Thread.sleep(1500);
                System.out.println("Invalid Mail!!");
                Thread.sleep(1500);
                System.out.println("Please enter a valid email address");
                email = sc.nextLine();
              matcher = pattern.matcher(email);
            }
            else 
            break;
        }
        User u = new User(name,email);
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection x2=DriverManager.getConnection("jdbc:mysql://localhost/ticket","root","jishnu321");
         String s2="select * from user order by user_id desc limit 1";
         PreparedStatement p2=x2.prepareStatement(s2);
         ResultSet r2=p2.executeQuery();
         r2.next();
         int n = r2.getInt(1)+1;
          String s3="insert into user value(?,?,?,?)";
         PreparedStatement p3=x2.prepareStatement(s3);
           p3.setInt(1,n);
           p3.setString(2,name);
           p3.setString(3,email);
           p3.setInt(4,0);
           p3.executeUpdate();
           
        Connection x=DriverManager.getConnection("jdbc:mysql://localhost/ticket","root","jishnu321");
        String s0="select name from user";
        PreparedStatement p0=x.prepareStatement(s0);
        ResultSet rs1=p0.executeQuery();
        int price1=5000;
        int price2=2000;
        int price3=1000;
        int price4=500;
        while(rs1.next())
          name =rs1.getString(1);
        String s="select v_id from vip";
        PreparedStatement p=x.prepareStatement(s);
        ResultSet rs=p.executeQuery();
        int c=1;
        rs.next();
      
        while(rs.next())
         c++;   
        String s4="select f_id from first";
        PreparedStatement p4=x.prepareStatement(s4);
        ResultSet rs4=p4.executeQuery();
        int c1=1;
        rs4.next();
       
        while(rs4.next())
         c1++;   
        String s5="select s_id from second";
        PreparedStatement p5=x.prepareStatement(s5);
        ResultSet rs5=p5.executeQuery();
        int c2=1;
        rs5.next();
      
        while(rs5.next())
         c2++;   
        String s6="select g_id from general";
        PreparedStatement p6=x.prepareStatement(s6);
        ResultSet rs6=p.executeQuery();
        int c3=1;
        rs6.next();
       
        while(rs6.next())
         c3++;   
        String arr[] = new String[] {"Vip","First class","Second class ","General"};
       Transaction t = new Transaction();
       t.ask(c, c1, c2, c3, arr, price1, price2, price3, price4, name);
        
            Thread.sleep(1500);
    	
              System.out.println("How many tickets do you need in each type?");
              System.out.println("Tickets for "+arr[0]+" :");
              int n1 = sc.nextInt();
              while(true)
              {
                  Thread.sleep(1000);
                  if(n1>=0)
                   break;
                  System.out.println("Invalid number of tickets!!!");
                  Thread.sleep(1000);
                  System.out.println("Please enter a valid no of tickets needed.");
                   n1 = sc.nextInt();
              }   
              while(true)
              { 
                  if(n1>c)
                  {
                    Thread.sleep(1000);
                    System.out.println("Sorry,we don't have enough tickets available!!");
                    Thread.sleep(1000);
                  System.out.println("Please enter no of tickets less than "+c+"!!!");
                  n1=sc.nextInt();
                   
                 }
                else
                 break;
             }
              
              System.out.println("Tickets for "+arr[1]+" :");
              int n2 = sc.nextInt();
              while(true)
              {
                  Thread.sleep(1000);
                  if(n2>=0)
                   break;
                  System.out.println("Invalid number of tickets!!!");
                  Thread.sleep(1000);
                  System.out.println("Please enter a valid no of tickets needed.");
                   n2 = sc.nextInt();
              }
              
              while(true)
              { 
                  if(n2>c1)
                  {
                    Thread.sleep(1000);
                    System.out.println("Sorry,we don't have enough tickets available!!");
                    Thread.sleep(1000);
                  System.out.println("Please enter no of tickets less than "+c1+"!!!");
                  n2=sc.nextInt();
                   
                 }
                else
                 break;
             }
              
              System.out.println("Tickets for "+arr[2]+" :");
              int n3 = sc.nextInt();
              while(true)
              {
                  Thread.sleep(1000);
                  if(n3>=0)
                   break;
                  System.out.println("Invalid number of tickets!!!");
                  Thread.sleep(1000);
                  System.out.println("Please enter a valid no of tickets needed.");
                   n3 = sc.nextInt();
              }
              while(true)
              { 
                  if(n3>c2)
                  {
                    Thread.sleep(1000);
                    System.out.println("Sorry,we don't have enough tickets available!!");
                    Thread.sleep(1000);
                  System.out.println("Please enter no of tickets less than "+c2+"!!!");
                  n3=sc.nextInt();
                   
                 }
                else
                 break;
             }
             
              System.out.println("Tickets for "+arr[3]+" :");
              int n4 = sc.nextInt();
              while(true)
              {
                  Thread.sleep(1000);
                  if(n4>=0)
                   break;
                  System.out.println("Invalid number of tickets!!!");
                  Thread.sleep(1000);
                  System.out.println("Please enter a valid no of tickets needed.");
                   n4 = sc.nextInt();
              }
              
              
              while(true)
              { 
                  if(n4>c3)
                  {
                    Thread.sleep(1000);
                    System.out.println("Sorry,we don't have enough tickets available!!");
                    Thread.sleep(1000);
                  System.out.println("Please enter no of tickets less than "+c3+"!!!");
                  n4=sc.nextInt();
                   
                 }
                else
                 break;
             }
              int t1=n1+n2+n3+n4;
              price1*=n1;
              price2*=n2;
              price3*=n3;
              price4*=n4;   
              int total = price1+price2+price3+price4;
              Thread.sleep(2000);
              System.out.println("The total price for "+t1+" tickets is "+total);
              Thread.sleep(1500);
              System.out.print("Please pay the amount:");
              Thread.sleep(1500);
              while(true)
              {
                  int tot = sc.nextInt();
                  int dum=tot;
                  if(dum==total){
                      Thread.sleep(1500);
                      System.out.println("Thanks for booking the tickets!!");
                      break;}
                      else if(tot>total ||tot>Integer.MAX_VALUE || tot<=0){
                          System.out.println("You have entered invalid amount!!!");
                          Thread.sleep(1500);
                          System.out.println("Please pay the correct amount!!");}
                          else {
                          Thread.sleep(1500);
                          dum=total-tot;
                          total=dum;
                  System.out.println("Please pay the remaining amount "+dum);}
              }  
              String s22="UPDATE user SET tic = ? WHERE user_id = ?";
              PreparedStatement p22=x2.prepareStatement(s22);
              p22.setInt(1,t1);
               p22.setInt(2,n);
               p22.executeUpdate();
             
         
              String s11 = "delete from vip where v_id=?";
              PreparedStatement p11=x.prepareStatement(s11);
              
              String s9 = "delete from first where f_id=?";
              PreparedStatement p9=x.prepareStatement(s9);
              
              String s7 = "delete from second where s_id=?";
              PreparedStatement p7=x.prepareStatement(s7);
              
              String s12 = "delete from general where g_id=?";
              PreparedStatement p12=x.prepareStatement(s12);
              
              while(n1>0) 
              {
            	  p11.setInt(1,c);
            	  c--;
            	  n1--;
            	  p11.executeUpdate();
              }
              
              while(n2>0) 
              {
            	  p9.setInt(1,c1);
            	  c1--;
            	  n2--;
            	  p9.executeUpdate();
              }
             
              while(n3>0) 
              {
            	  p7.setInt(1,c2);
            	  c2--;
            	  n3--;
            	  p7.executeUpdate();
              }
             
              while(n4>0) 
              {
            	  p12.setInt(1,c3);
            	  c3--;
            	  n4--;
            	  p12.executeUpdate();
              }
             
             
                 sc.close();
                }  
    public void st(String nam,String email) throws ClassNotFoundException,SQLException,InterruptedException{
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 Scanner sc = new Scanner(System.in);
         Connection x2=DriverManager.getConnection("jdbc:mysql://localhost/ticket","root","jishnu321");
         String s2="select * from user";
         PreparedStatement p2=x2.prepareStatement(s2);
         ResultSet r2=p2.executeQuery();
         int c=0;
         while(r2.next())
        	  if(nam.equals(r2.getString(2)) && email.equals(r2.getString(3)))
        	  {
        		  int ti = r2.getInt(4);
                 c++;
        		  System.out.println("How many tickets do you want to cancel:");
        		  int n1 = sc.nextInt();
        		  while(true)
                  {
                      Thread.sleep(1000);
                      if(n1>0)
                       break;
                      System.out.println("Invalid number of tickets!!!");
                      Thread.sleep(1000);
                      System.out.println("Please enter a valid no of tickets to be cancelled.");
                       n1 = sc.nextInt();
                  }   
                  while(true)
                  { 
                      if(n1>ti)
                      {
                        Thread.sleep(1000);
                        System.out.println("Sorry,You can't cancel ticket more than "+ti);
                        Thread.sleep(1000);
                      System.out.println("Please enter no of tickets less than "+ti+"!!!");
                      n1=sc.nextInt();
                       
                     }
                      else if(n1<1)
                      {
                    	  System.out.println("Invalid ticket ");
                    	  System.out.println("Please enter a valid ticket number: ");
                    	  n1 = sc.nextInt();
                      }
                    else
                     break;
                  }
                   if(n1==ti) 
                   {
                 	  System.out.println("Tickets cancelled!!");
                	   
                	   String s12 = "delete from user where tic=?";
                	   PreparedStatement p12=x2.prepareStatement(s12);
                	   
                	   while(n1>0) 
                	   {
                		   p12.setInt(1,ti);
                		   ti--;
                		   n1--;
                		   p12.executeUpdate();
                	   }
                   }
                  else 
                  {
                	  String s33="select * from user order by user_id desc limit 1";
                      PreparedStatement p33=x2.prepareStatement(s33);
                      ResultSet r33=p33.executeQuery();
                      r33.next();
                      int n = r33.getInt(1);
                      System.out.println(n);
                	  System.out.println("Tickets cancelled!!");
                  
                  String s22="UPDATE user SET tic = ? WHERE user_id = ?";
                  PreparedStatement p22=x2.prepareStatement(s22);
                  p22.setInt(1,n1);
                   p22.setInt(2,n);
                   p22.executeUpdate();
                  }
        	  }
         if(c==0)
        	  System.out.println("NO such name or email!");
        		  
        		   
    }
}



class User{
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}


