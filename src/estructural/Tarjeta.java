/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructural;

/**
 *
 * @author Paleox
 */
public class Tarjeta {
    
    private String documento;
    private double saldo;
    private char[] password;
    private int tipo;

    public Tarjeta(String documento, double saldo, char[] password, int tipo) {
        this.documento = documento;
        this.saldo = saldo;
        this.password = password;
        this.tipo = tipo;
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
    public char[] getPassword(){
        return password;
    }
    
    public void setPassword(char[] password){
        this.password = password;
    }

    public String getDocumento() {
        return documento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void recargarTarjeta(double saldo){
        this.saldo += saldo;
    }
    
    public void actualizarSaldo(double saldo){
        /*if(saldo > this.saldo)
        {
            throw new Exception("Saldo insuficiente");
        }*/
        this.saldo -= saldo;
    }
    
}
