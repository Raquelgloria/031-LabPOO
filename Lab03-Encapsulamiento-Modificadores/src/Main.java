/*RAQUEL GUADALUPE GLORIA VAZQUEZ #2011258
PRACTICA 3 - ENCAPSULAMIENTO Y MODIFICADORES DE ACCESO
LABORATORIO DE PROGRAMACION ORIENTADA A OBJETOS GPO031
 */

import Aereo.Avion;
import Maritimo.Barco;
import Terrestres.Automovil;
/*import Vehiculos.Vehiculo;*/

public class Main {

    public static void main(String[] args){
        System.out.println("***SISTEMA DE TRASPORTES MULTIMODAL ***");
        System.out.println("Vehiculo Terrestre");
    
        Automovil auto = new Automovil("Toyota", "Corolla", 2020, 180.0, 4, "No");
        auto.describir();
        auto.getMarca();
        auto.getModelo();
        auto.getAnio();
        auto.getVelocidadMax();
        auto.setNumeroPuertas(10);
        auto.setEsElectrico("No");
        System.out.println(auto.toString());



        System.out.println("Vehiculo Maritimo");
        Barco barco = new Barco("FERRETI", "bucanero", 2005, 45.5, 3, "Diesel");
        barco.describir();
        barco.getMarca();
        barco.getAnio();
        barco.getModelo();
        barco.getTipoMotor();
        barco.getVelocidadMax();
        barco.setTipoMotor("Diesel");
        barco.setCantMastiles(3);
        System.out.println(barco.toString());


        System.out.println("Vehiculo Aereo");
        Avion avion = new Avion("Boeing", "747", 2010, 900.0, 4, "Si");
        avion.describir();
        avion.getMarca();
        avion.getModelo();
        avion.getAnio();
        avion.getVelocidadMax();
        avion.setCantMotores(4);
        avion.setAerolinea("Lufthansa");
        System.out.println(avion.toString());
    }
}
