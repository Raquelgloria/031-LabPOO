public class Canario extends Animal {
    private String colorPlumaje;
    private Boolean Cantarenjaula;

    public Canario(String nombre, int edad, double peso, String colorPlumaje, Boolean Cantarenjaula) {
        super(nombre, edad, peso);
        this.colorPlumaje = colorPlumaje;
        this.Cantarenjaula = Cantarenjaula;
    }

    public void cantar() {
        System.out.println(getNombre() + " está cantando.");
    }

    public void volar() {
        System.out.println(getNombre() + " está volando.");
    }

    @Override
    public String toString() {
        return "Canario{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", peso=" + getPeso() +
                ", colorPlumaje='" + colorPlumaje + '\'' +
                ", Cantarenjaula=" + Cantarenjaula +
                '}';
    }

}
