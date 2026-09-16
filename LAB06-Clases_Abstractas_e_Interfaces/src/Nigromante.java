public class Nigromante extends Personaje implements Hechicero {
	private int mana;
	private int almasAbsorbidas;
	private int nivelOscuridad;

	public Nigromante(String nombre, int nivel, int puntosVida, int mana, int almasAbsorbidas) {
		this(nombre, nivel, puntosVida, mana, almasAbsorbidas, 1);
	}

	public Nigromante(String nombre, int nivel, int puntosVida, int mana, int almasAbsorbidas, int nivelOscuridad) {
		super(nombre, nivel, puntosVida);
		this.mana = mana;
		this.almasAbsorbidas = almasAbsorbidas;
		this.nivelOscuridad = nivelOscuridad;
	}

	@Override
	public void atacar() {
		System.out.println(getNombre() + " drena la vida de su enemigo e invoca no-muertos, causando " + calcularDanio() + " puntos de daño.");
	}

	@Override
	public int calcularDanio() {
		return (mana + almasAbsorbidas) * getNivelOscuridad();
	}

	@Override
	public void lanzarHechizo() {
		System.out.println(getNombre() + " lanza una maldicion oscura.");
	}

	public int getMana() {
		return mana;
	}

	@Override
	public int getNivelMagia() {
		return mana;
	}

	public int getAlmasAbsorbidas() {
		return almasAbsorbidas;
	}

	public int getNivelOscuridad() {
		return nivelOscuridad;
	}
}
