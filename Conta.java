package com.example.bancodigital.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_conta")
public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected double saldo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    protected Cliente cliente;

    public Conta() {
    }

    public Conta(Cliente cliente) {
        this.saldo = 0.0;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public abstract void sacar(double valor);

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
}
