/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.daw1.evaluacion2concesionario;

import java.time.LocalDate;
import org.daw.evaulacion2.clases.Coche;
import org.daw.evaulacion2.clases.Concesionario;
import org.daw.evaulacion2.clases.TipoVehiculo;

/**
 *
 * @author Rafael González Centeno
 */
public class Evaluacion2Concesionario {

    private static java.util.Scanner sc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sc = new java.util.Scanner(System.in);
        String cif = "no hay cif";
        String nombre = "no hay nombre";
        

         do {
             System.out.println("Inserte el nombre del concesionario");
            nombre = sc.nextLine();
            if (nombre == null || nombre.isBlank() || !Concesionario.PATRON_NOMBRE.matcher(nombre).matches()) {
                System.out.println("Inserte un nombre valido");
            }
        } while (nombre == null || nombre.isBlank() || !Concesionario.PATRON_NOMBRE.matcher(nombre).matches());
        
        do {
            System.out.println("Inserte el Cif del concesionario");
            cif = sc.nextLine();
            if (cif == null || cif.isBlank() || !Concesionario.PATRON_CIF.matcher(cif).matches()) {
                System.out.println("Inserte un cif valido");
            }

        } while (cif == null || cif.isBlank() || !Concesionario.PATRON_CIF.matcher(cif).matches());

        Concesionario con1 = new Concesionario(cif, nombre);
        
        
        String opcion;
        do {
            System.out.println("*************************************************************");
            System.out.println("* 1. Alta vehículo                                          *");
            System.out.println("* 2. Registrar venta vehículo                               *");
            System.out.println("* 3. Mostrar número e importe de vehículos no vendidos      *");
            System.out.println("* 4. Mostrar número e importe de vehículos vendidos         *");
            System.out.println("* 5. Mostrar listado de vehículos no vendidos               *");
            System.out.println("* 6. Mostrar listado de vehículos vendidos                  *");
            System.out.println("*                                                           *");
            System.out.println("* 0. Salir                                                  *");
            System.out.println("*************************************************************");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    //Damos de alta un nuevo vehículo y lo guardamos en el concesionario. Validar datos.
                        
                    
                    con1.addVehiculo(new Coche("marca", "modelo", "AAAAAA1AAAA111111", TipoVehiculo.of(1), 1000.0, 20, LocalDate.now()));

                    //Coche(String marca, String modelo, String bastidor, TipoVehiculo tipoVehiculo, double precioCompra, int margenDeVeneficio, int precioVenta, LocalDate fechaCompra)
                    break;
                case "2":
                    //Mostramos vehículos no vendidos. El usuario inserta la matrícula y se marca como vendido el vehículo a fecha de hoy (Esta función te puede ayudar: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/LocalDate.html#now())
                    
                    break;
                case "3":
                    //Muestra cuantos coches están pendientes de vender y el importe total de venta de estos (teniendo en cuenta que el PVP sigue la fórmula del documento)

                    break;
                case "4":
                    //Muestra cuantos coches están vendidos y el importe total de venta de estos (teniendo en cuenta que el PVP sigue la fórmula del documento)

                    break;
                case "5":
                    //Muestra los datos de los coches no vendidos haciendo un System.out.println(vehiculo). Se muestran todos los datos del coche.

                    break;
                case "6":
                    //Muestra los datos de los coches vendidos haciendo un System.out.println(vehiculo). Se muestran todos los datos del coche.

                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!opcion.equals("0"));
    }

}
