package com.br.acme_pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;
    private Customer customer;
    private List<String> transactions;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Account create() {
        // TODO: 23/04/24
        return this;
    }

    public void deposit(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount must not be null");
        }
        this.setBalance(this.getBalance().add(amount));
    }

    public void withdraw(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount must not be null");
        }
        if (checkBalance(amount)) {
            this.setBalance(this.getBalance().subtract(amount));
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public void transfer(Account destiny, BigDecimal amount) {
        if (destiny == null || amount == null) {
            throw new IllegalArgumentException("Destination account and amount must not be null");
        }
        if (checkBalance(amount)) {
            destiny.setBalance(destiny.getBalance().add(amount));
            this.setBalance(this.getBalance().subtract(amount));
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    private boolean checkBalance(BigDecimal amount) {
        return this.getBalance().compareTo(amount) >= 0;
    }
}
