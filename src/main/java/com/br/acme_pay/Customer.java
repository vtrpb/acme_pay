package com.br.acme_pay;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private static Map<Long, Customer> customers = new HashMap<>();
    private static long nextId = 1;

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document_type;
    private String document_number;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    // Constructor
    public Customer(String name, String email, String phone, String document_type, String document_number) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document_type = document_type;
        this.document_number = document_number;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
        customers.put(this.id, this); // Add to the map upon creation
    }

    // CRUD methods implemented within the Customer class
    public static Customer create(String name, String email, String phone, String document_type, String document_number) {
        return new Customer(name, email, phone, document_type, document_number);
    }

    public static Customer delete(Long id) {
        return customers.remove(id);
    }

    public static Customer update(Long id, String name, String email, String phone, String document_type, String document_number) {
        Customer customer = customers.get(id);
        if (customer != null) {
            customer.name = name;
            customer.email = email;
            customer.phone = phone;
            customer.document_type = document_type;
            customer.document_number = document_number;
            customer.updated_at = LocalDateTime.now();
        }
        return customer;
    }

    public static List<Customer> list() {
        return new ArrayList<>(customers.values());
    }

    public static Customer recoverByDocumentNumber(String document_number) {
        for (Customer customer : customers.values()) {
            if (customer.document_number.equals(document_number)) {
                return customer;
            }
        }
        return null;
    }
}


