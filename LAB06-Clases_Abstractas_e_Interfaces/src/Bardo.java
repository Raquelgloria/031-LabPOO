public class Bardo extends Personaje implements Sanador {
	private int poderCuracion;
	private String instrumento;
	private int carisma;

	public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion, String instrumento) {
		this(nombre, nivel, puntosVida, poderCuracion, instrumento, 1);
	}

	public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion, String instrumento, int carisma) {
		super(nombre, nivel, puntosVida);
		this.poderCuracion = poderCuracion;
		this.instrumento = instrumento;
		this.carisma = carisma;
	}

	@Override
	public void atacar() {
		System.out.println(getNombre() + " aturde con su musica y su " + instrumento + ", causando " + calcularDanio() + " puntos de daño.");
	}

	@Override
	public int calcularDanio() {
		return carisma * getNivel();
	}

	@Override
	public void curarAliado(Personaje aliado) {
		if (aliado != null) {
			aliado.recibirDanio(-poderCuracion);
			System.out.println(getNombre() + " toca una melodia curativa para " + aliado.getNombre() + ".");
		}
	}

	public int getPoderCuracion() {
		return poderCuracion;
	}

	@Override
	public int getNivelSanacion() {
		return poderCuracion;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public int getCarisma() {
		return carisma;
	}
}
