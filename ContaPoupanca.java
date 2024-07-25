package com.example.bancodigital.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CP")
public class ContaPoupanca extends Conta {

    private double taxaJuros;

    public ContaPoupanca() {
    }

    public ContaPoupanca(Cliente cliente, double taxaJuros) {
        super(cliente);
        this.taxaJuros = taxaJuros;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public void aplicarRendimento() {
        saldo += saldo * taxaJuros;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }
}
