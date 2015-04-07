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
public class Funcion {
    
    private int codigo;
    private Date fecha;
    private Sala sala;
    private Pelicula pelicula;

    public Funcion(int codigo, Date fecha, Sala sala, Pelicula pelicula) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.sala = sala;
        this.pelicula = pelicula;
    }

    public Date getFecha() {
        return fecha;
    }

    public Sala getSala() {
        return sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
     
}
