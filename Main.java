package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Random;

  class bankdetails {
      long account_number;
       String name;
      String surname;
      String account_type;
      int balance ;
      int pin =1234;
      String address;
      long adhaar_number;
      String pan_number;
      long contact_number;
      String dob;
      int x;

      Scanner sc = new Scanner(System.in);

      public void Account_opening() {

           System.out.println(" please enter your first name ");
            name=sc.next();

           System.out.println(" please enter your surname ");
            surname=sc.next();

           System.out.println(" please enter your contact number ");
            contact_number=sc.nextLong();

           System.out.println(" please enter your adhaar number ");
            adhaar_number=sc.nextLong();

            System.out.println(" please enter your pancard number ");
            pan_number =sc.next();

           System.out.println(" please enter your date  of birth ");
            dob =sc.next();

           System.out.println(" please enter your Address ");
            address =sc.next();

           System.out.println(" please enter account type ");
            account_type = sc.next();

           System.out.println(" please enter initial balance  ");
            balance = sc.nextInt();

          System.out.println(" Please Enter Mpin");
           pin = sc.nextInt();
           getpin();

           Random num = new Random();
           account_number =num.nextLong(1 ,1000000000);

      }

      public void displayaccount(){
           System.out.println(" Your account number :"+ account_number);
           System.out.println("account holder name :"+ name + surname);
           System.out.println("account account type :"+ account_type);
           System.out.println("account date of birth :"+ dob);
           System.out.println("account adhar number :"+ adhaar_number);
           System.out.println("account pan card number :"+ pan_number);
           System.out.println("account address :"+ address);
           System.out.println("account contact number :"+ contact_number);
           System.out.println("account balance :"+ balance);

      }

      public void getpin(){
          int newpin;
          System.out.println("Enter your pin");
          newpin = sc.nextInt();
          if (pin == newpin){
              System.out.println("entered pin is verified");
          }
              else {
                  System.out.println("Sorry!!!... you have entered wrong pin please try again");
                  getpin();
              }

          }

          public void resetpin(){
          int prev_pin;
              System.out.println("Enter your prevoius pin");
              prev_pin = sc.nextInt();
              if (pin==prev_pin){
                  System.out.println("entered pin is correct now enter new pin");
                  pin = sc.nextInt();
                  System.out.println("congratulation pin is set successfully" + pin);
                  getpin();
              }
          }

          public void resetnumber(){
          long prev_number;
              getpin();
              System.out.println("enter previous number");
              prev_number = sc.nextLong();
              if (prev_number==contact_number){
                  System.out.println("Enter new number to link with bank account");
                  contact_number = sc.nextLong();
                  System.out.println("congratulation number is set successfully");

              }else {
                  System.out.println("sooorrry!!! ....you have entered wrong number please try again");
                  resetnumber();
              }
          }

      public void deposit (){
          getpin();
          int  ammt;
          System.out.println("enter amount to be deposited");
          ammt = sc.nextInt();
          balance = balance + ammt;
          System.out.println("congratulation money  is deposited  successfully");


      }

      public void withdraw (){
          getpin();
          int ammt;
          System.out.println("enter ammount to be withdrawn");
          ammt = sc.nextInt();
          if (balance >= ammt && ammt%100 == 0){
              balance = balance - ammt;
              System.out.println("balance after withdrawl"+ balance);
          } else if (ammt%100 != 0){

              System.out.println("Please Enter amount in multiple of 100 ");
              withdraw();
          }

          else {
              System.out.println("balance in your account is "+ balance + "so transaction failed");
              System.out.println("please Enter valid amount");
              withdraw();
          }
      }

      /*public boolean search(int ac_no) {
          if ((ac_no) == account_number) {
              displayaccount();
              return (true);
          }
          return (false);
      }*/


      public void login(){
          System.out.println("Enter account number");
          account_number = sc.nextLong();
          getpin();
      }

      public void prev_menu(){

          System.out.println("1.Login");
          System.out.println("2.New account Opening");
          System.out.println("Enter your Transsaction");
          int input = sc.nextInt();
          if (input == 1) {
              login();
              menu();
          }
              else if (input == 2){
                 Account_opening();
              System.out.println("Your account Created Successfully ");
              menu();
              }
              else {
              System.out.println("Please Enter valid Selection");
              prev_menu();
          }
              actionperformed();
          }

          public void conti(){
              System.out.println("if you want to continue press 1");
              System.out.println("if you want to exit press 2");

               x = sc.nextInt();

               if (x==1) {
                   menu();
               }else if (x==2) {
                   exit();
               }else {
                       System.out.println("Enter valid selection");
                       conti();
                   }
          }

       public void menu (){

           System.out.println("now select trasaction to be proceed");
           System.out.println("1.Account details");
           System.out.println("2.Withdraw Money");
           System.out.println("3.Deposit Money");
           System.out.println("4.Reset Pin");
           System.out.println("5.Reset Number");
           System.out.println("6.Update");
           System.out.println("7.Exit");
           System.out.println("Please give Your Selection");
           int input = sc.nextInt();

            if (input ==1){
               displayaccount();
               conti();
           }
           else if (input ==2){
               withdraw();
               conti();
           }
           else if (input ==3){
               deposit();
               conti();
           }
           else if (input ==4){
               resetpin();
               conti();

           }
           else if (input ==5){
               resetnumber();
               conti();

           }

           else if (input==7){
               exit();
               System.out.println(" visit again !!! ");
           }
         else if (input==6){
               update();
            }

            else {
               System.out.println("Please give valid Selection");
               menu();
           }

       }

           public void exit (){}

      public void actionperformed(){

          String url ="jdbc:mysql:///Account_details";
          String username="root";
          String pass ="Sagar@321";

          try {
              Statement stmt;
              Connection c = DriverManager.getConnection(url,username,pass);
                  String query = "insert into details values( '"+account_number+"', '"+name+"','"+surname+"','"+account_type+"','"+dob+"','"+adhaar_number+"','"+pan_number+"','"+address+"','"+contact_number+"','"+balance+"')";
                  stmt = c.createStatement();
                  stmt.executeUpdate(query);

          }catch (Exception e){
              System.out.println(e);
          }
      }

          public void update () {

          System.out.println("1.Update name");
          System.out.println("2.Update Surname");
          System.out.println("3.Update phone_no");
          System.out.println("4.Update Adress");

          int update = sc.nextInt();

          if (update == 1) {
              update_name();
          }
             else  if (update == 2) {
                 update_Surname();
          }
          else  if (update == 3) {
              update_phone_no();
          }
          else  if (update == 4) {
              update_address();
          }
          else {
              System.out.println("enter valid selection");
          }

      }

          public void update_name (){

              String up_name;

              String url = "jdbc:mysql:///Account_details";
              String username = "root";
              String pass = "Sagar@321";

              System.out.println("Enter new name");
              up_name=sc.next();

              System.out.println("Enter adhaar_number");
              long adhaarnumber = sc.nextLong();

              try {
                  //Statement stmt;
                  Connection c = DriverManager.getConnection(url, username, pass);
                  String updateQuery = "UPDATE details SET name = ? WHERE adhaar_number = ?";
                  PreparedStatement statement = c.prepareStatement(updateQuery);

                  statement.setString(1, up_name);
                  statement.setLong(2, adhaarnumber); // Assuming the primary key value is adhaar_number

                  int rowsUpdated = statement.executeUpdate();

                  if (rowsUpdated > 0) {
                      System.out.println("update successful!");
                  } else {
                      System.out.println("No rows were updated.");
                  }

              } catch (Exception e) {
                  System.out.println(e);
              }


          }

           public void update_Surname (){

          String up_surname;

          String url = "jdbc:mysql:///Account_details";
          String username = "root";
          String pass = "Sagar@321";

          System.out.println("Enter new name");
          up_surname=sc.next();

          System.out.println("Enter adhaar_number");
          long adhaarnumber = sc.nextLong();

          try {
              //Statement stmt;
              Connection c = DriverManager.getConnection(url, username, pass);
              String updateQuery = "UPDATE details SET surname = ? WHERE adhaar_number = ?";
              PreparedStatement statement = c.prepareStatement(updateQuery);

              statement.setString(1, up_surname);
              statement.setLong(2, adhaarnumber); // Assuming the primary key value is adhaar_number

              int rowsUpdated = statement.executeUpdate();

              if (rowsUpdated > 0) {
                  System.out.println("update successful!");
              } else {
                  System.out.println("No rows were updated.");
              }

          } catch (Exception e) {
              System.out.println(e);
          }

      }

      public void update_phone_no (){

          int phone_no;

          String url = "jdbc:mysql:///Account_details";
          String username = "root";
          String pass = "Sagar@321";

          System.out.println("Enter new number");
          phone_no=sc.nextInt();

          System.out.println("Enter adhaar_number");
          long adhaarnumber = sc.nextLong();

          try {
              //Statement stmt;
              Connection c = DriverManager.getConnection(url, username, pass);
              String updateQuery = "UPDATE details SET contact_number = ? WHERE adhaar_number = ?";
              PreparedStatement statement = c.prepareStatement(updateQuery);

              statement.setLong(1, phone_no);
              statement.setLong(2, adhaarnumber); // Assuming the primary key value is adhaar_number

              int rowsUpdated = statement.executeUpdate();

              if (rowsUpdated > 0) {
                  System.out.println("update successful!");
              } else {
                  System.out.println("No rows were updated.");
              }

          } catch (Exception e) {
              System.out.println(e);
          }
      }


      public void update_address (){

          String newaddress;

          String url = "jdbc:mysql:///Account_details";
          String username = "root";
          String pass = "Sagar@321";

          System.out.println("Enter new address");
          newaddress=sc.next();

          System.out.println("Enter adhaar_number");
          long adhaarnumber = sc.nextLong();

          try {
              //Statement stmt;
              Connection c = DriverManager.getConnection(url, username, pass);
              String updateQuery = "UPDATE details SET address = ? WHERE adhaar_number = ?";
              PreparedStatement statement = c.prepareStatement(updateQuery);

              statement.setString(1, newaddress);
              statement.setLong(2, adhaarnumber); // Assuming the primary key value is adhaar_number

              int rowsUpdated = statement.executeUpdate();

              if (rowsUpdated > 0) {
                  System.out.println("update successful!");
              } else {
                  System.out.println("No rows were updated.");
              }

          } catch (Exception e) {
              System.out.println(e);
          }
      }
  }


public class Main {

    public static void main(String[] args) {
        System.out.println("****  welcome to my bank  *****");
        bankdetails obj = new bankdetails();

       //   obj.Account_opening();

       // obj.deposit();

      //  obj.withdraw();

       //obj.displayaccount();

       //obj.resetpin();

       // obj.resetnumber();

        //obj.login();

        //obj.menu();

        //obj.Account_opening();

       // obj.displayaccount();

        obj.prev_menu();
        //obj.actionperformed();

       // obj.conti();
        }
    }

