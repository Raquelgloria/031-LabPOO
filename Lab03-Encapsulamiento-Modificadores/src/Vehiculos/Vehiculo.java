package Vehiculos;

public class Vehiculo {

    private String marca;
    private String modelo;
    private int anio;
    protected double velocidadMax;

    public Vehiculo(String marca, String modelo, int anio, double velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidadMax = velocidadMax;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if(anio >= 1885 && anio < 2100) {
            this.anio = anio;
        }else {
            System.out.println("Error: año no valido");
        } 
        }
    
        public double getVelocidadMax() {
            return velocidadMax;
        }
    

    public void setVelocidadMax(double velocidadMax) {
        if(velocidadMax > 0) {
            this.velocidadMax = velocidadMax;
        } else {
            System.out.println("Error: velocidad máxima no valida");
        }
        
    }

    public void describir() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
        System.out.println("Velocidad Máxima: " + velocidadMax + " km/h");
    }

    public String toString(){
        return (
            "Marca: " + marca +
            "| Modelo: " + modelo +
            "| Año: " + anio + 
            "| Velocidad Máxima: " + velocidadMax + " km/h"
        );
    }

}
