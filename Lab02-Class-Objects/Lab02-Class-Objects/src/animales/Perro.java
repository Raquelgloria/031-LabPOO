public class Perro extends Animal {
    private String raza;
    private Boolean estaVacunado;

    public Perro(String nombre, int edad, double peso, String raza, Boolean estaVacunado) {
        super(nombre, edad, peso);
        this.raza = raza;
        this.estaVacunado = estaVacunado;
    }

    public void ladrar() {
        System.out.println(getNombre() + " está ladrando.");
    }

    public void buscarPelota() {
        System.out.println(getNombre() + " está buscando la pelota.");
    }

    @Override
    public String toString() {
        return "Perro{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", peso=" + getPeso() +
                ", raza='" + raza + '\'' +
                ", estaVacunado=" + estaVacunado +
                '}';
    }


}
