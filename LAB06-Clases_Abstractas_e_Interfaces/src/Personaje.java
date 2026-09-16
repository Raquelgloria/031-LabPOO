public abstract class Personaje implements Combatiente {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected boolean estaVivo;
    

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

    // En Personaje:
    public void mostrarEstado(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Puntos de Vida: " + puntosVida);
    }                    
    public void mostrarEstado(boolean detallado){
        if (detallado) {
            System.out.println("Nombre: " + nombre);
            System.out.println("Nivel: " + nivel);
            System.out.println("Puntos de Vida: " + puntosVida);
            System.out.println("Estado: " + (estaVivo ? "Vivo" : "Muerto"));
        } else {
            System.out.println("Nombre: " + nombre + ", Nivel: " + nivel + ", Puntos de Vida: " + puntosVida);
        }
    }  
    
    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida < 0) {
            puntosVida = 0;
        }
        estaVivo = puntosVida > 0;
}
    /* 
    public int calcularDanio() {
        return getNivel() * 10; 
    }
*/
    public abstract void atacar();
    public abstract int calcularDanio();
/* 
    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con un ataque básico.");
       
        }

*/
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

