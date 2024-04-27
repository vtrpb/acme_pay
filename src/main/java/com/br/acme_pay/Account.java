package br.com.acme_pay;

import java.math.BigDecimal;

public class Account {


    private Integer number;


    private Long id;
    private Integer accountNumber;
    private Integer agencyNumber;
    private Double balance;

    public void deposit(BigDecimal amount)  {
        this.balance.add(amount);
    }
    public void withdraw(BigDecimal amount) {
        // Compare usando compareTo em vez de >= porque BigDecimal não suporta operadores diretamente
        if (this.balance.compareTo(amount) >= 0) {
            // É necessário atribuir o resultado de subtract de volta à balance, pois BigDecimal é imutável
            this.balance = this.balance.subtract(amount);
        } else {
            // Complete a exceção que você deseja lançar
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public void transfer(Account origin, Account destiny, BigDecimal amount) {

        if (origin.balance.compareTo(amount) >= 0) {

            destiny.balance.add(amount);
            origin.balance = origin.balance.subtract(amount);

        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }


}
