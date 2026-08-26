package Aereo;
import Vehiculos.Vehiculo;

public class Avion extends Vehiculo{
    private int cantMotores;
    private String aerolinea;

    public Avion(String marca, String modelo, int anio, double velocidadMax, int cantMotores, String aerolinea) {
        super(marca, modelo, anio, velocidadMax);
        this.cantMotores = cantMotores;
        this.aerolinea = aerolinea;
    }

    public int getCantMotores() {
        return cantMotores;
    }

    public void setCantMotores(int cantMotores) {
        if(cantMotores > 0) {
            this.cantMotores = cantMotores;
        } else {
            System.out.println("Error: cantidad de motores no valida");
        }
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    @Override
    public String toString(){
        return (
            "Marca: " + getMarca() +
            "| Modelo: " + getModelo() +
            "| Año: " + getAnio() + 
            "| Velocidad Máxima: " + velocidadMax + " km/h"+
            "| Cantidad de Motores: " + cantMotores +
            "| Aerolínea: " + aerolinea
        );
    }

}
