package com.pesante;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Bank bank = new Bank("Bank of Minnesota");


        // Add branches here:
        bank.addBranch("Cambridge");
        bank.addBranch("Roseville");
        bank.addBranch("Minneapolis");
        bank.addBranch("Andover");

        if (!bank.addBranch("Minneapolis")){
            System.out.println("Minneapolis branch already exists");
        }
        else {
            System.out.println("Branch added");
        }
        bank.addCustomer("Cambridge","Joe P",1000.50);
        bank.addCustomer("Cambridge","Raina P",500.00);
        bank.addCustomer("Cambridge","Alex P",100.00);


        bank.addCustomer("Roseville","Tony P",500.00);

        bank.addCustomerTransaction("Cambridge","Joe P",200.00);
        bank.addCustomerTransaction("Roseville","Tony p",100.00);

        bank.listCustomers("Cambridge",false);
        bank.listCustomers("Roseville",true);



    }
}
