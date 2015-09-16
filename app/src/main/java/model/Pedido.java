package model;

import java.util.ArrayList;

/**
 * Created by Filipe on 2015-08-28.
 */
public class Pedido {
/*
     Atributos:
            1. Cliente cli;
    2. ArrayList<Produto> produtos;
    3. double valorTotal
     Métodos:
            1. cadastrarCliente();
    2. cadastrarProdutos();
    3. exibirDadosCadastrados.*/

    private Cliente cli;
    private ArrayList<Produto> produtos;
    private double valorTotal;

    public void cadastrarCliente(Cliente cliente){
        this.cli = cliente;
    }

    public void cadastrarProdutos(Produto produto){
        this.produtos.add(produto);
    }

    public void exibirDadosCadastrados() {

    }
}
