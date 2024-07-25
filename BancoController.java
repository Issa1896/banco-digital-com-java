package com.example.bancodigital.controller;

import com.example.bancodigital.model.Cliente;
import com.example.bancodigital.model.Conta;
import com.example.bancodigital.model.ContaCorrente;
import com.example.bancodigital.model.ContaPoupanca;
import com.example.bancodigital.repository.ClienteRepository;
import com.example.bancodigital.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BancoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    @PostMapping("/clientes")
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PostMapping("/contas")
    public Conta adicionarConta(@RequestParam Long clienteId, @RequestParam String tipoConta,
            @RequestParam double limiteOuTaxa) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Conta conta;
        if ("corrente".equalsIgnoreCase(tipoConta)) {
            conta = new ContaCorrente(cliente, limiteOuTaxa);
        } else if ("poupanca".equalsIgnoreCase(tipoConta)) {
            conta = new ContaPoupanca(cliente, limiteOuTaxa);
        } else {
            throw new IllegalArgumentException("Tipo de conta inválido.");
        }
        return contaRepository.save(conta);
    }

    @GetMapping("/contas")
    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    @PostMapping("/depositar")
    public Conta depositar(@RequestParam Long contaId, @RequestParam double valor) {
        Conta conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
        conta.depositar(valor);
        return contaRepository.save(conta);
    }

    @PostMapping("/sacar")
    public Conta sacar(@RequestParam Long contaId, @RequestParam double valor) {
        Conta conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
        conta.sacar(valor);
        return contaRepository.save(conta);
    }
}
