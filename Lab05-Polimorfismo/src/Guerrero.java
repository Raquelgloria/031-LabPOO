public class Guerrero extends Personaje {
    private int fuerza;
    private String armadura;

    public Guerrero(String nombre, int nivel, int puntosVida, int fuerza, String armadura) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    public int getFuerza() {
        return fuerza;
    }

    public String getArmadura() {
        return armadura;
    }

    @Override
    public int calcularDanio() {
        return fuerza * getNivel() * 15; // Ejemplo: daño aumentado para el guerrero
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " ataca con su espada, causando " + fuerza + " puntos de daño.");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " se defiende con su armadura " + armadura + ".");
    }

    @Override
    public String toString() {
        return "Guerrero{" +
                "nombre='" + getNombre() + '\'' +
                ", nivel=" + getNivel() +
                ", puntosVida=" + getPuntosVida() +
                ", estaVivo=" + isEstaVivo() +
                ", fuerza=" + fuerza +
                ", armadura='" + armadura + '\'' +
                '}';
    }

}
