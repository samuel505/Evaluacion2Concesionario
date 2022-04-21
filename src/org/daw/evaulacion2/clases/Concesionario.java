/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw.evaulacion2.clases;

import java.util.Map;
import java.util.Objects;
import static java.util.Objects.hash;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 *
 * @author alumno
 */
public class Concesionario implements Comparable<Concesionario>{

    private Map<String, Set<Coche>> coche = new TreeMap<>();

    public final static Pattern PATRON_CIF = Pattern.compile("[A-Z][0-9]{8}");
    public final static Pattern PATRON_NOMBRE = Pattern.compile("[a-zA-Z0-9\\.]+");
    private final String cif;
    private final String nombre;

    public Concesionario(String cif, String nombre) {
        checkNombre(nombre);
        checkCif(cif);
        
        this.cif = cif;
        this.nombre = nombre;
    }

    public static void checkNombre(String nombre) {
        if (nombre == null || !PATRON_NOMBRE.matcher(nombre).matches()) {
            throw new IllegalArgumentException();

        }

    }

    public static void checkCif(String cif) {
        if (cif == null || !PATRON_CIF.matcher(cif).matches()) {
            throw new IllegalArgumentException();

        }

    }
    
    int comprados = 0;
    public int addVehiculo(Coche c){
        
        if (!coche.containsKey(c.getBastidor())) {
            coche.put(c.getBastidor(), new TreeSet<Coche>());
        }
        coche.get(c.getBastidor()).add(c);
        
        comprados++;
        
        return comprados;
    }
    
    private int venta = 0;
    public int getVentas(int venta){
        venta = this.venta+1;
       
        return venta;
    }

    @Override
    public String toString() {
        return "Concensionario{" + "cif=" + cif + ", nombre=" + nombre + ", venta=" + venta + '}';
    }

    @Override
    public int hashCode() {
        return hash(this.cif);
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
        final Concesionario other = (Concesionario) obj;
        if (!Objects.equals(this.cif, other.cif)) {
            return false;
        }
        return true;
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public int getComprados() {
        return comprados;
    }

    public int getVenta() {
        return venta;
    }

    @Override
    public int compareTo(Concesionario t) {
    return this.cif.compareTo(t.cif);
    }

    public void setComprados(int comprados) {
        this.comprados=comprados;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    
     
    
   
    
}
