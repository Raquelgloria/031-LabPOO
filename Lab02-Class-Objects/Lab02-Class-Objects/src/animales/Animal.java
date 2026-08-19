public class Animal {
    private String nombre;
    private int edad;
    private double peso;

    public Animal(String nombre, int edad, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public void comer() {
        System.out.println(getNombre() + " está comiendo.");
    }

    public void dormir() {
        System.out.println(getNombre() + " está durmiendo.");
    }

    public String toString() {
        return "Animal{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", peso=" + getPeso() +
                '}';
    }
}
