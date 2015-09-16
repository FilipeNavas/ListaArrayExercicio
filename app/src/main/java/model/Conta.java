package model;

/**
 * Created by Filipe on 2015-08-28.
 */
public class Conta {

    private int numero;
    private Cliente cli;
    private double saldo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean sacar(double valor){

        if(saldo >= valor){
            saldo = saldo - valor;
            return true;
        }else{
            return false;
        }

    }

    public void depositar(double valor){

        saldo = saldo + valor;

    }
}
