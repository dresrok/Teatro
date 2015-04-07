/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructural;

import java.util.ArrayList;

/**
 *
 * @author Paleox
 */
public class Reserva {
    
    private int codigo;
    private int estado;
    private double total;
    
    private Funcion funcion;    
    private Tarjeta tarjeta;
    private ArrayList<Silla> sillas;

    public Reserva(int codigo, Funcion funcion, Tarjeta tarjeta, ArrayList<Silla> sillas, double total) {
        this.codigo = codigo;       
        this.funcion = funcion;
        this.tarjeta = tarjeta;
        this.sillas = sillas;
        this.total = total;
        this.estado = 1;
    }
    
    public int getEstado(){
        return this.estado;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public Tarjeta getTarjeta(){
        return this.tarjeta;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public double getTotal(){
        return this.total;
    }
    
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    public Funcion getFuncion(){
        return this.funcion;
    }
    
    public ArrayList<Silla> getSillas(){
        return this.sillas;
    }    
    
}
