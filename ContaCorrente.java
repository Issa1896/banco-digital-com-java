package com.example.bancodigital.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;

    public ContaCorrente() {
    }

    public ContaCorrente(Cliente cliente, double limiteChequeEspecial) {
        super(cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente, incluindo o limite do cheque especial.");
        }
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
}
