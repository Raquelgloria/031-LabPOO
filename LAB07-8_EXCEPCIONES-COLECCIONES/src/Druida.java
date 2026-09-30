public class Druida extends Personaje implements Sanador, Hechicero {
    private int mana;
    private int poderCuracion;
    private String vinculoAnimal;

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion) {
        this(nombre, nivel, puntosVida, mana, poderCuracion, "Buho");
    }

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, String vinculoAnimal) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.vinculoAnimal = vinculoAnimal;
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " ataca con fuerzas de la naturaleza, causando " + calcularDanio() + " puntos de daño.");
    }

    @Override
    public int calcularDanio() {
        return mana * getNivel();
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(getNombre() + " lanza un hechizo de naturaleza usando su vinculo con el " + vinculoAnimal + ".");
    }

    public int getMana() {
        return mana;
    }

    @Override
    public int getNivelMagia() {
        return mana;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        if (aliado != null) {
            aliado.recibirDanio(-poderCuracion);
        }
    }

    public int getPoderCuracion() {
        return poderCuracion;
    }

    @Override
    public int getNivelSanacion() {
        return poderCuracion;
    }

    public String getVinculoAnimal() {
        return vinculoAnimal;
    }
}
