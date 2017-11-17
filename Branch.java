package com.pesante;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch (String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();



    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }

    public boolean newCustomer(String customerName, Double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName,initialAmount));
            return true;
        }

        return false;
    }

    public boolean addCustomerTransaction(String customerName, Double amount) {
        Customer existingCustomer = findCustomer(customerName);

        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;

        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        for (int i =0; i<this.customers.size(); i++){
    Customer checkedCustomer = this.customers.get(i);
    if(checkedCustomer.getName().contains(customerName)) { // I'm using .contians here to make the search easier, otherwise .equals, it has to be spelled exactly right to find the record.
        return checkedCustomer;
    }



        }
return null;

    }
}
