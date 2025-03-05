Bank Management System

Overview

This is a simple Bank Management System implemented in Java. It allows users to create a bank account, deposit and withdraw money, reset PINs and contact numbers, and update account details. The system also integrates with a MySQL database to store and retrieve user information securely.

Features

1.Open a new bank account

2.Login using an account number and PIN

3.View account details

4.Deposit and withdraw money

5.Reset PIN

7.Update contact number

8.Update account details (name, surname, phone number, address)

9.Validate user input for secure transactions

10.Store account details in a MySQL database

Prerequisites

Before running the project, ensure you have the following installed:

1.Java Development Kit (JDK) 8 or later

2.MySQL Database Server

3.JDBC Driver for MySQL

4.IntelliJ IDEA or any Java-compatible IDE 

Database Setup

1.Create a MySQL database named Account_details.

2.Create a table details using the following SQL script:

CREATE TABLE details (
    account_number BIGINT PRIMARY KEY,
    name VARCHAR(50),
    surname VARCHAR(50),
    account_type VARCHAR(20),
    dob VARCHAR(20),
    adhaar_number BIGINT UNIQUE,
    pan_number VARCHAR(20),
    address VARCHAR(255),
    contact_number BIGINT,
    balance INT
);

3.Update the database credentials in the actionperformed() and update methods:

String url = "jdbc:mysql:///Account_details";
String username = "root";
String pass = "your_password_here";

How to Run the Project

1.Clone the repository: git clone https://github.com/sagarghodke1204/bank-management-system.git

2.Open the project in IntelliJ IDEA or any other Java IDE.

3.Compile and run Main.java.

4.Follow the on-screen instructions to create an account or log in.

Usage

Select 1 to log in with an existing account.

Select 2 to create a new bank account.

3.Navigate through the menu to perform transactions like deposits, withdrawals, and updates.

Contributing

Feel free to fork the repository and submit pull requests with improvements or new features.
