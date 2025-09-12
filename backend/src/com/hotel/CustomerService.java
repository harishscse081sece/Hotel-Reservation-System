package com.hotel;

import java.util.ArrayList;

public class CustomerService {
    private ArrayList<Customer> customers = new ArrayList<>();
    private int nextId = 1;

    public Customer addCustomer(String name, String contact) {
        Customer c = new Customer(nextId++, name, contact);
        customers.add(c);
        return c;
    }

    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }
}
