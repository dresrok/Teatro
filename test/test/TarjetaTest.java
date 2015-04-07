/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import estructural.*;
import junit.framework.TestCase;

/**
 *
 * @author Andres
 */
public class TarjetaTest extends TestCase {
    
    //---------------------------------------------------------------
    // Atributos
    //---------------------------------------------------------------
    
    /**
     * Teatro para obtener el saldo inicial
     * y el saldo de recarga
     */
    private Teatro teatro;
    
    /**
     * Es la clase de donde se harán las pruebas
     */
    private Tarjeta tarjeta;
    
    //---------------------------------------------------------------
    // Métodos
    //--------------------------------------------------------------- 
    
    /**
     * Crea una nueva tarjeta
     */
    private void setupEscenario1( )
    {
        String password = "14200797";
        int tipo = 3;
        tarjeta = new Tarjeta("14200697", Teatro.SALDO_INICIAL, password.toCharArray(), tipo);
    }
    
    /**
     * Prueba de saldo inicial
     */
    public void testCargaInicial( )
    {
        setupEscenario1();
        double saldo = Teatro.SALDO_INICIAL;
        assertEquals("El saldo inicial es inválido", saldo, tarjeta.getSaldo());
    }
    
    /**
     * Prueba de recargar tarjeta
     */
    public void testRecargar( )
    {
        setupEscenario1();
        tarjeta.recargarTarjeta(Teatro.SALDO_RECARGA);
        double saldo = tarjeta.getSaldo();
        assertEquals("El saldo después de la recarga es inválido", saldo, tarjeta.getSaldo());
    }
    
    /**
     * Prueba de actualizar saldo
     */
    public void testResta( )
    {
        setupEscenario1();
        double saldo =  tarjeta.getSaldo() - 6430;
        try {
            tarjeta.actualizarSaldo(6430);
        } catch (Exception e) {
            fail("Error al actualizar el saldo de de la tarjeta");
        }
        assertEquals("El saldo después de actualizarlo es inválido", saldo, tarjeta.getSaldo());
    }
    
    /**
     * Prueba de saldo insuficiente
     */
    public void testSaldoInsuficiente( )
    {
        setupEscenario1();
        try {
            tarjeta.actualizarSaldo(Teatro.SALDO_INICIAL + 1);
            fail("No debería poder restar un saldo mayor al que posee la tarjeta");
        } catch (Exception e) {
            assertTrue("Esta excepción era esperada", true);
        }
    }
}
