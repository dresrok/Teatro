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
    private ArrayList<Reserva> reservas;
    
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
        String password = "14200679";
        int tipo = 3;
        tarjetas.add(new Tarjeta("14200679", Teatro.SALDO_INICIAL, password.toCharArray(), tipo));
        
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
     * Escenario para cancelar reserva
     */
    private void setupEscenario2( )
    {
        teatro = new Teatro();
        salas = teatro.getSalas();
        salas.add(new Sala(1, 10, 10));
        peliculas = teatro.getPeliculas();
        peliculas.add(new Pelicula(1, "Rapido Y Furioso 7", 180));
        
        tarjetas = teatro.getTarjetas();
        String password = "38218037";
        int tipo = 3;
        tarjetas.add(new Tarjeta("38218037", Teatro.SALDO_INICIAL, password.toCharArray(), tipo));
        
        funciones = teatro.getFunciones();
        String fecha = "2015/04/07 15:00";
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date fechaConversion = null;
        
        try {
            fechaConversion = df.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        funciones.add(new Funcion(1, fechaConversion, teatro.getSala(1), teatro.getPelicula(1)));
        
        ArrayList<Silla> sillas = new ArrayList<>();
        sillas.add(new Silla(1, 8));
        reservas =  teatro.getReservas();
        reservas.add(new Reserva(1, teatro.getFuncion(1), teatro.getTarjeta("38218037"), sillas, teatro.calcularTotal(sillas)));
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
        setupEscenario2();
        try {   
            int size = 0;
            Reserva reserva =  teatro.getReserva(1);
            teatro.cancelarReserva(reserva.getCodigo());            
            assertEquals("La reserva no fue cancelara", size, reservas.size());
        } catch (Exception e) {
            fail( "Error al cancelar la reserva" );
        }
    }
}
