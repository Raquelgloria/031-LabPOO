public class Personaje implements Combatiente {
    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;
    

    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
            System.out.println(nombre + " ha muerto.");
        }
        System.out.println(nombre + " ha recibido " + danio + " puntos de daño. vida restantes: " + puntosVida);
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con un ataque básico.");
       
        }


    @Override
    public void defender() {
        System.out.println(nombre + " se pone en defensa.");
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntosVida=" + puntosVida +
                ", estaVivo=" + estaVivo +
                '}';
    }

}
