/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructural;

import java.util.Date;

/**
 *
 * @author Paleox
 */
public class Pelicula {

    private int codigo;
    private String titulo;
    private int duracion;

    public Pelicula(int codigo, String titulo, int duracion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracion = duracion;
    }
    
    public int getCodigo() {
        return this.codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }
    
    
    
  
    
}
