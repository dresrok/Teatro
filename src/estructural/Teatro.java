/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructural;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Paleox
 */
public class Teatro {
    
    public static final double TARIFA_PREFERENCIAL = 20000;
    public static final double TARIFA_GENERAL = 12000;
    public static final double SALDO_INICIAL = 70000;
    public static final double SALDO_RECARGA = 50000;
    public static final double DESCUENTO = 0.2;
    
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Funcion> funciones;
    private ArrayList<Sala> salas;
    private ArrayList<Tarjeta> tarjetas;
    private ArrayList<Reserva> reservas;

    public Teatro() {
        this.peliculas = new ArrayList<>();
        this.funciones = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.tarjetas = new ArrayList<>();
        this.reservas = new ArrayList<>();
        cargarDefecto();
    }
    
    public int getCodigoPelicula(){
        int codigo = this.peliculas.size()+1;
        return codigo;         
    }
    
    public int getCodigoSala(){
        return this.salas.size()+1;
    }
    
    public int getCodigoReserva(){
        return this.reservas.size()+1;
    }
    
    public int getCodigoFuncion(){
        return this.funciones.size()+1;
    }
    
    public ArrayList<Sala> getSalas(){
        return this.salas;
    }
    
    public ArrayList<Reserva> getReservas(){
        return this.reservas;
    }
    
    public ArrayList<Reserva> getReservasActivas(){
        ArrayList<Reserva> reservasActivas = new ArrayList<>();
        for (Reserva reserva : this.reservas) {
            if (reserva.getEstado() == 1) {
                reservasActivas.add(reserva);
            }
        }
        return reservasActivas;
    }
    
    public ArrayList<Tarjeta> getTarjetas(){
        return this.tarjetas;
    }
    
    public ArrayList<Funcion> getFunciones(){
        return this.funciones;
    }
    
    public Sala getSala(int codSala){
        for(Sala sala : salas){
            if(sala.getCodigo() == codSala){
                return sala;
            }
        }
        return null;
    }
    
    public Funcion getFuncion(int codFuncion){
        for(Funcion funcion : funciones){
            if(funcion.getCodigo() == codFuncion){
                return funcion;
            }
        }
        return null;
    }
    
    public Reserva getReserva(Funcion funcion, int colu, int fila){
        int i = 0;
        
        for(Reserva reserva : reservas){
            if(reserva.getFuncion().getCodigo() == funcion.getCodigo()){
                for(Silla silla : reserva.getSillas()){
                    if(silla.getNumeroColumna() == colu && silla.getNumeroFila() == fila){
                        return reserva;
                    }
                }
                
            }            
        }
        return null;
    }
    
    public Reserva getReserva(int codReserva){
        for(Reserva reserva: reservas){
            if(reserva.getCodigo() == codReserva){
                return reserva;
            }
        }
        return null;
    }
    
    public Pelicula getPelicula(int codPelicula){
        for(Pelicula pelicula : peliculas){
            if(pelicula.getCodigo() == codPelicula){
                return pelicula;
            }
        }
        return null;
    }
    
    public ArrayList<Pelicula> getPeliculas(){
        return this.peliculas;
    }
    
    public void crearSalaTeatro(int columnas, int filas){
        this.salas.add(new Sala(salas.size()+1,columnas,filas));
    }
    
    public void configurarSilla(int codSala, int numCol, int numFil, int tipo){
        this.getSala(codSala).getSilla(numCol, numFil).setTipo(tipo);        
    }
    
    public void crearFuncion(Date fecha, Sala sala, Pelicula pelicula){
        this.funciones.add(new Funcion(funciones.size()+1,fecha, sala, pelicula));
    }
    
    public void registrarPelicula(String titulo, int duracion){
        this.peliculas.add(new Pelicula(peliculas.size()+1, titulo, duracion));
    }
    
    public void registrarTarjeta(String documento, char[] password){
        this.tarjetas.add(new Tarjeta(documento, SALDO_INICIAL, password, 3));
    }
   
    public void recargarTarjeta(String documento){
        for (Tarjeta tarjeta : tarjetas) {
            if(tarjeta.getDocumento().equals(documento)) {
                tarjeta.recargarTarjeta(SALDO_RECARGA);
            }
        }
    }
    
    public void crearReserva(Funcion funcion, Tarjeta tarjeta, ArrayList<Silla> sillas){
        int codigoReserva = reservas.size();
        
        do{
            codigoReserva++;
        }while(reservas.contains(getReserva(codigoReserva)));
        
        this.reservas.add(
            new Reserva(codigoReserva, funcion, tarjeta, sillas,
            calcularTotal(sillas)));
    }
    
    public double calcularTotal(ArrayList<Silla> sillas){
        double total = 0.0;
        for (Silla silla : sillas) {
            switch(silla.getTipo()) {
                case 1:
                    total += TARIFA_GENERAL;
                    break;
                case 2:
                    total += TARIFA_PREFERENCIAL;
            }
        }
        return total;
    }
    
    public void cancelarReserva(int codReserva){
        for (int i = 0; i < reservas.size(); i++) {
            if(reservas.get(i).getCodigo() == codReserva) {
                reservas.remove(i);                
            }
        }
    }
    
    public void registrarVenta(Reserva reserva, Tarjeta tarjeta, int tipo) throws Exception{
        if(tarjeta != null){
            reserva.setTotal(reserva.getTotal() * (1-DESCUENTO));
        }
        
        if(tarjeta != null && tipo == 2 && 
                tarjeta.getSaldo() >= reserva.getTotal()){
            tarjeta.actualizarSaldo(reserva.getTotal());
        }
        
        reserva.setEstado(2);
    }
    
    public Tarjeta getTarjeta(String documento){
        for (Tarjeta tarjeta : tarjetas) {
            if(tarjeta.getDocumento().equals(documento)) {
                return tarjeta;
            }
        }
        return null;
    }
    
    public ArrayList<Reserva> getReservasTarjeta(String documento){
        ArrayList<Reserva> reservasTarjeta =  new ArrayList<>();
        for(Reserva reserva: reservas){
            if(reserva.getTarjeta().getDocumento().equals(documento)){
                reservasTarjeta.add(reserva);                
            }
        }
        return reservasTarjeta;
    }
    
    public ArrayList<Reserva> getReservasTarjeta(String documento, int estado){
        ArrayList<Reserva> reservasTarjeta =  new ArrayList<>();
        for(Reserva reserva: reservas){
            if(reserva.getTarjeta().getDocumento().equals(documento)
                    && reserva.getEstado() != estado){
                reservasTarjeta.add(reserva);                
            }
        }
        return reservasTarjeta;
    }
    
    public ArrayList<Reserva> getReservasFuncion(Funcion funcion){
        ArrayList<Reserva> reservasFuncion = new ArrayList<>();
        for(Reserva reserva : reservas){
            if(reserva.getFuncion().equals(funcion) && reserva.getEstado() == 1){
                reservasFuncion.add(reserva);
            }
        }
        return reservasFuncion;
    }
    
    public Funcion getFuncionReserva(int codReserva){
        for(Reserva reserva: reservas){
            if(reserva.getCodigo() == codReserva){
                return reserva.getFuncion();
            }
        }
        return null;
    }
    
   
    public void cargarDefecto(){
        salas.add(new Sala(salas.size()+1, 10, 10));
        salas.add(new Sala(salas.size()+1, 20, 20));
        
        peliculas.add(new Pelicula(peliculas.size()+1, "Viernes 13", 60));
        peliculas.add(new Pelicula(peliculas.size()+1, "La casa de cera", 60));
        
        String str = "1110488441";         
        tarjetas.add(new Tarjeta("1110488441", SALDO_INICIAL, str.toCharArray(), 3));
        str = "1110495218";
        tarjetas.add(new Tarjeta("1110495218", SALDO_INICIAL, str.toCharArray(), 3));
        str = "admin";
        tarjetas.add(new Tarjeta("admin", SALDO_INICIAL, str.toCharArray(), 1));
        str = "taquillero";
        tarjetas.add(new Tarjeta("taquillero", SALDO_INICIAL, str.toCharArray(), 2));
        
        String fecha = "2015/03/16 15:00";
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date fechaConversion = null;
        
        try {
            fechaConversion = df.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        funciones.add(new Funcion(funciones.size()+1, fechaConversion, this.getSala(1), this.getPelicula(1)));
        funciones.add(new Funcion(funciones.size()+1, fechaConversion, this.getSala(2), this.getPelicula(2)));
        
        ArrayList<Silla> sillas = new ArrayList<>();
        ArrayList<Silla> sillas2 = new ArrayList<>();
        sillas.add(new Silla(1, 8));
        sillas.add(new Silla(1, 9));
        sillas.add(new Silla(1, 10));
        
        sillas2.add(new Silla(2, 4));
        sillas2.add(new Silla(2, 5));
        sillas2.add(new Silla(2, 6));
        
        reservas.add(new Reserva(reservas.size()+1, this.getFuncion(1), this.getTarjeta("1110488441"), sillas, this.calcularTotal(sillas)));
        reservas.add(new Reserva(reservas.size()+1, this.getFuncion(1), this.getTarjeta("1110495218"), sillas2, this.calcularTotal(sillas2)));
    }
    
    public Tarjeta validarAcceso(String documento, char[] password){
        for(Tarjeta tarjeta : tarjetas){
            if(tarjeta.getDocumento().equals(documento)
                    && Arrays.toString(tarjeta.getPassword()).equals(Arrays.toString(password))){
                return tarjeta;
            }
        }
        return null;
    }
}

