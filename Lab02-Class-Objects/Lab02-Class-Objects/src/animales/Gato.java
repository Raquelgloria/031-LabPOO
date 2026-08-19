public class Gato extends Animal {
    private String color;
    private Boolean esDomestico;

    public Gato(String nombre, int edad, double peso, String color, Boolean esDomestico) {
        super(nombre, edad, peso);
        this.color = color;
        this.esDomestico = esDomestico;
    }

    public void maullar() {
        System.out.println(getNombre() + " está maullando.");
    }

    public void ronrronear() {
        System.out.println(getNombre() + " está ronroneando.");
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", peso=" + getPeso() +
                ", color='" + color + '\'' +
                ", esDomestico=" + esDomestico +
                '}';
    }

}
