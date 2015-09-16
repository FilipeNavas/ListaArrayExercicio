package model;

import java.util.ArrayList;

/**
 * Created by Filipe on 2015-08-28.
 */
public class Banco {

   /* Crie uma classe Banco que contenha os seguintes itens:
             Atributos:
            1. ArrayList<Conta> contas.
             Métodos:
            1. Cadastrar Contas;
    2. Editar Contas;
    3. Excluir Contas.*/

    private ArrayList<Conta> contas;

    public void cadastrarConta(Conta conta){

        this.contas.add(conta);

    }

    public void editarConta(Conta conta, int numero){


    }

    public void excluirConta(int numero){

    }

}



