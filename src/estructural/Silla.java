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
public class Silla {
    
    private int numeroColumna;
    private int numeroFila;
    private int tipo;

    public Silla(int numeroColumna, int numeroFila) {
        this.numeroColumna = numeroColumna;
        this.numeroFila = numeroFila;
        this.tipo = 1;
    }

    public int getNumeroColumna() {
        return numeroColumna;
    }

    public int getNumeroFila() {
        return numeroFila;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    
    
}
