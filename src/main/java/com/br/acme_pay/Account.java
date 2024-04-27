package br.com.acme_pay;

import java.math.BigDecimal;

public class Account {


    private Integer number;


    private Long id;
    private Integer accountNumber;
    private Integer agencyNumber;
    private Double balance;

    public void deposit(BigDecimal amount)  {
        this.balance = this.balance.add(amount);
    }
    public void withdraw(BigDecimal amount) {

        if (checkBalance(amount)) {

            this.balance = this.balance.subtract(amount);
        } else {
            // Complete a exceção que você deseja lançar
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public void transfer(Account destiny, BigDecimal amount) {

        if (checkBalance(amount)) {

            destiny.balance.add(amount);
            this.balance = this.balance.subtract(amount);

        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    private boolean checkBalance(BigDecimal amount)  {

        return this.balance.compareTo(amount) >= 0;

    }




}
