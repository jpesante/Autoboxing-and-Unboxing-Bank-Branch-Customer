package com.pesante;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();

    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName,initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName,amount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for(int i = 0; i<this.branches.size(); i++){
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().contains(branchName)){
                return checkedBranch;
            }

        }
return null;

    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i<branchCustomers.size(); i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println();
                System.out.println("Customer " + branchCustomer.getName() + " at branch " + branchName + "[" + i + "]");
                if(showTransactions) {
                    System.out.println();
                    System.out.println("Transactions" );
                    System.out.println();
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j = 0; j< transactions.size(); j++) {
                        System.out.println("[" + (j + i) + "] Amount " + transactions.get(j));
                    }
                }
            }
        return true;
        } else {
            return false;
        }

    }









}
