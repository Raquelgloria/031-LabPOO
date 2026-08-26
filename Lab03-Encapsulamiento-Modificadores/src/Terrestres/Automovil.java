package Terrestres;
import Vehiculos.Vehiculo;

public class Automovil extends Vehiculo {
    private int numeroPuertas;
    private String esElectrico;

    public Automovil(String marca, String modelo, int anio, double velocidadMax, int numeroPuertas, String esElectrico) {
        super(marca, modelo, anio, velocidadMax);
        this.numeroPuertas = numeroPuertas;
        this.esElectrico = esElectrico;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        if(numeroPuertas > 0 && numeroPuertas <= 6) {
            this.numeroPuertas = numeroPuertas;
        } else {
            System.out.println("Error: número de puertas no valido");
        }
    }

    public String getEsElectrico() {
        return esElectrico;
    }

    public void setEsElectrico(String esElectrico) {
        this.esElectrico = esElectrico;
    }

    @Override
    public String toString(){
        return (
            "Marca: " + getMarca() +
            "| Modelo: " + getModelo() +
            "| Año: " + getAnio() + 
            "| Velocidad Máxima: " + velocidadMax + " km/h"+
            "| Número de Puertas: " + numeroPuertas +
            "| Es Eléctrico: " + esElectrico
        );
    }

}
