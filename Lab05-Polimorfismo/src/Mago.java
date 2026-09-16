public class Mago extends Personaje {
    private int poderMagico;
    private String elemento;

    public Mago(String nombre, int nivel, int puntosVida,int poderMagico, String elemento) {
        super(nombre, nivel, puntosVida);
        this.poderMagico = poderMagico;
        this.elemento = elemento;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public String getElemento() {
        return elemento;
    }

    @Override
    public int calcularDanio() {
        return poderMagico * getNivel() * 12; // Ejemplo: daño aumentado para el mago
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " lanza un hechizo de " + elemento + ", causando " + poderMagico + " puntos de daño.");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " se protege con un escudo mágico.");
    }

    @Override
    public String toString() {
        return "Mago{" +
                "nombre='" + getNombre() + '\'' +
                ", nivel=" + getNivel() +
                ", puntosVida=" + getPuntosVida() +
                ", estaVivo=" + isEstaVivo() +
                ", poderMagico=" + poderMagico +
                ", elemento='" + elemento + '\'' +
                '}';
    }

}

