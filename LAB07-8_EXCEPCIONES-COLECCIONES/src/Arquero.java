public class Arquero extends Personaje {
    private final int precision;
    private final String tipoArco;
    private int flechasDisponibles;

    public Arquero(String nombre, int nivel, int puntosVida, int precision, String tipoArco) {
        super(nombre, nivel, puntosVida);
        this.precision = precision;
        this.tipoArco = tipoArco;
        this.flechasDisponibles = 20;
    }

    public int getPrecision() {
        return precision;
    }

    public String getTipoArco() {
        return tipoArco;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    @Override
    public int calcularDanio() {
        return precision * getNivel() * 10; // Ejemplo: daño aumentado para el arquero
    }

    @Override
    public void atacar() {

        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (flechasDisponibles <= 0) {
            throw new RecursoInsuficienteException("flechas", flechasDisponibles);
        }

        flechasDisponibles--;
        System.out.println("[" + getNombre() + "] dispara una flecha. " +
                           "Flechas restantes: " + flechasDisponibles);
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
