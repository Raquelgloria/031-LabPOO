package Maritimo;
import Vehiculos.Vehiculo;

public class Barco extends Vehiculo{
    private int cantMastiles;
    private String tipoMotor;

    public Barco(String marca, String modelo, int anio, double velocidadMax, int cantMastiles, String tipoMotor) {
        super(marca, modelo, anio, velocidadMax);
        this.cantMastiles = cantMastiles;
        this.tipoMotor = tipoMotor;
    }

    public int getCantMastiles() {
        return cantMastiles;
    }

    public void setCantMastiles(int cantMastiles) {
        if(cantMastiles > 0) {
            this.cantMastiles = cantMastiles;
        } else {
            System.out.println("Error: cantidad de mastiles no valida");
        }
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    @Override
    public String toString(){
        return (
            "Marca: " + getMarca() +
            "| Modelo: " + getModelo() +
            "| Año: " + getAnio() + 
            "| Velocidad Máxima: " + velocidadMax + " km/h"+
            "| Número de Mastiles: " + cantMastiles +
            "| Tipo de Motor: " + tipoMotor
        );
    }

}
