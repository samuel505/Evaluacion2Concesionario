/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw.evaulacion2.clases;

import java.time.LocalDate;
import java.util.Objects;
import static java.util.Objects.hash;
import java.util.regex.Pattern;


/**
 *
 * @author alumno
 */
public class Coche implements Comparable<Coche>{

    private final String marca;
    private final String modelo;
    private final String bastidor;
    private final TipoVehiculo tipoVehiculo;
    private final double precioCompra;
    private int margenDeVeneficio;
    private final double precioVenta;
    private final LocalDate fechaCompra;
    private final LocalDate fechaVenta;
    public final static Pattern PATRON_BASTIDOR = Pattern.compile("[A-Z]{6}[0-9][A-Z]{4}[0-9]{6}");
    public final static Pattern PATRON_MARCAMODELO = Pattern.compile("[a-zA-Z0-9 ]+");
    
    public Coche(String marca, String modelo, String bastidor, TipoVehiculo tipoVehiculo, double precioCompra, int margenDeVeneficio, LocalDate fechaCompra) {
        checkMarca(marca);
        checkmodelo(modelo);
        checkBastidor(bastidor);
        checkTipoVehiculo(tipoVehiculo);
        checkPrecioCompra(precioCompra);
        checkMargenVeneficio(margenDeVeneficio);                
        checkFechaCompra(fechaCompra);        
             
        
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.tipoVehiculo = tipoVehiculo;
        this.precioCompra = precioCompra;
        this.margenDeVeneficio = margenDeVeneficio;
        this.precioVenta = getPrecioventa(precioCompra,margenDeVeneficio);
        this.fechaCompra = fechaCompra;
        this.fechaVenta = null;
    }

    private static void checkMarca(String marca) {
        if (marca == null || !PATRON_MARCAMODELO.matcher(marca).matches()) {
            throw new IllegalArgumentException();
        }

    }

    private static void checkmodelo(String modelo) {
        if (modelo == null || !PATRON_MARCAMODELO.matcher(modelo).matches()) {
            throw new IllegalArgumentException();
        }

    }

    private static void checkBastidor(String numBastidor) {
        if (numBastidor == null || !PATRON_BASTIDOR.matcher(numBastidor).matches()) {
            throw new IllegalArgumentException();
        }

    }

    private static void checkTipoVehiculo(TipoVehiculo tipoVehiculo) {
        if (tipoVehiculo == null) {
            throw new NullPointerException();

        }

    }

    private static void checkPrecioCompra(double precioCompra) {
        if (precioCompra < 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkMargenVeneficio(int margen) {
        if (margen < 1) {
            throw new IllegalArgumentException();
        }

    }

    private static void checkPrecioVenta(double precioVenta) {
        if (precioVenta < 1) {
            throw new IllegalArgumentException();
        }
    }
    

    private static void checkFechaCompra(LocalDate fechaCompra) {
        if (fechaCompra== null || fechaCompra.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException();

        }

    }

    private static void checkFechaVenta(LocalDate fechaVenta) {
        if (fechaVenta != null || fechaVenta.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException();
        }

    }

     public double getPrecioventa(double precioCompra,int margen){
      return precioCompra+((precioCompra*margen)/100);
         
    }
    
    
    public String getBastidor() {
        return bastidor;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    @Override
    public int hashCode() {
       return hash(this.bastidor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coche other = (Coche) obj;
        if (!Objects.equals(this.bastidor, other.bastidor)) {
            return false;
        }
        return true;
    }

    public void setMargenDeVeneficio(int margenDeVeneficio) {
        checkMargenVeneficio(margenDeVeneficio);
        this.margenDeVeneficio = margenDeVeneficio;
    }

    @Override
    public String toString() {
        return "Marca:"+" "+this.marca+"\n"+"Modelo:"+" "+this.modelo+"\n"+"Bastidor"+" "+this.bastidor+"\n"+"Precio Compra:"+" "+this.precioCompra+"\n"+"Margen"+" "+this.margenDeVeneficio+"%"+"\n"+"PVP"+" "+this.precioVenta+"\n"+"Fecha compra"+" "+this.fechaCompra+"\n"+"Fecha venta"+" "+this.fechaVenta+"\n";
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public int getMargenDeVeneficio() {
        return margenDeVeneficio;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    @Override
    public int compareTo(Coche t) {
       return this.bastidor.compareTo(t.bastidor);
        
    }
    
    
    

}
