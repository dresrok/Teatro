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
public class Sala {
    
    private int codigo;
    private int columnas;
    private int filas;
    private int estado;
    private ArrayList<Silla> sillas;

    public Sala(int codigo, int columnas, int filas) {
        this.codigo = codigo;
        this.columnas = columnas;
        this.estado = 1;
        this.filas = filas;
        this.sillas = new ArrayList<>();
        for (int i = 1; i <= columnas; i++) {
            for (int j = 1; j <= filas; j++) {
                sillas.add(new Silla(i,j));
            }
        }
    }
    
    public Silla getSilla(int columna, int fila){
        for(Silla silla : sillas){
            if(silla.getNumeroColumna() == columna &&
                    silla.getNumeroFila() == fila){
                return silla;
            }
        }
        return null;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }
    
    public ArrayList<Silla> getSillas(){
        return sillas;
    }
    
}
