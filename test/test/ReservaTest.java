/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import estructural.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import junit.framework.TestCase;

/**
 *
 * @author Andres
 */
public class ReservaTest extends TestCase {
    
    //---------------------------------------------------------------
    // Atributos
    //---------------------------------------------------------------
    
    /**
     * Es la clase de donde se harán las pruebas
     */
    private Teatro teatro;
    private Reserva reserva;
    
    private ArrayList<Sala> salas;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Funcion> funciones;    
    private ArrayList<Tarjeta> tarjetas;
    
    //---------------------------------------------------------------
    // Métodos
    //--------------------------------------------------------------- 
    
    /**
     * Configura todos los requisitos para 
     * crear una reserva
     */
    private void setupEscenario1( )
    {        
        teatro = new Teatro();
        salas = teatro.getSalas();
        salas.add(new Sala(1, 10, 10));
        peliculas = teatro.getPeliculas();
        peliculas.add(new Pelicula(1, "Los vengadores", 90));
        
        tarjetas = teatro.getTarjetas();
        String password = "14200697";
        int tipo = 3;
        tarjetas.add(new Tarjeta("14200697", Teatro.SALDO_INICIAL, password.toCharArray(), tipo));
        
        funciones = teatro.getFunciones();
        String fecha = "2015/04/06 15:00";
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date fechaConversion = null;
        
        try {
            fechaConversion = df.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        funciones.add(new Funcion(1, fechaConversion, teatro.getSala(1), teatro.getPelicula(1)));
    }
    
    /**
     * Prueba crear reserva
     */
    public void testCrearReserva( )
    {
        setupEscenario1();
        try {
            ArrayList<Silla> sillas = new ArrayList<>();
            sillas.add(new Silla(1, 8));
            reserva = new Reserva(1, teatro.getFuncion(1), teatro.getTarjeta("14200697"), sillas, teatro.calcularTotal(sillas));
            double total = teatro.calcularTotal(sillas);
            assertEquals("La reserva no tiene el valor correcto", total, reserva.getTotal());
        } catch (Exception e) {
            fail( "Error al crear la reserva" );
        }
    }
    
    /**
     * Prueba cancelar reserva
     */
    public void testCancelarReserva( )
    {
        
    }
}
