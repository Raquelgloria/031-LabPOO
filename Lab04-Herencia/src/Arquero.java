public class Arquero extends Personaje {
    private int precision;
    private String tipoArco;

    public Arquero(String nombre, int nivel, int puntosVida, int precision, String tipoArco) {
        super(nombre, nivel, puntosVida);
        this.precision = precision;
        this.tipoArco = tipoArco;
    }

    public int getPrecision() {
        return precision;
    }

    public String getTipoArco() {
        return tipoArco;
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " dispara una flecha con su " + tipoArco + ", causando " + precision + " puntos de daño.");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " se protege con su arco.");
    }

    @Override
    public String toString() {
        return "Arquero{" +
                "nombre='" + getNombre() + '\'' +
                ", nivel=" + getNivel() +
                ", puntosVida=" + getPuntosVida() +
                ", estaVivo=" + isEstaVivo() +
                ", precision=" + precision +
                ", tipoArco='" + tipoArco + '\'' +
                '}';
    }

}
