
import java.util.ArrayList;

public class GestorBatalla {

    private ArrayList<String> historial = new ArrayList<>();

    // Versión 1: un solo atacante
    public void ejecutarAtaque(Personaje atacante) {
        int danio = atacante.calcularDanio();

        atacante.atacar();

        historial.add("El personaje " + atacante.getNombre()
                + " realizó un ataque de " + danio + " de daño.");
    }

    // Versión 2: atacante vs defensor
    public void ejecutarAtaque(Personaje atacante, Personaje defensor) {
        int danio = atacante.calcularDanio();

        atacante.atacar();

        defensor.recibirDanio(danio);
        defensor.defender();

        historial.add("El personaje " + atacante.getNombre()
                + " atacó a " + defensor.getNombre()
                + " causando " + danio + " de daño.");
    }

    // Versión 3: todo un equipo ataca
    public void ejecutarAtaque(Personaje[] equipo) {
        for (Personaje atacante : equipo) {
            int danio = atacante.calcularDanio();

            atacante.atacar();

            historial.add("El personaje " + atacante.getNombre()
                    + " realizó un ataque de " + danio + " de daño.");
        }
    }

    
    public void mostrarHistorial() {
        System.out.println("--------HISTORIAL DE BATALLA ---------");

        for (String evento : historial) {
            System.out.println(evento);
        }
    }

    
    public void limpiarHistorial() {
        historial.clear();
        System.out.println("Historial limpiado.");
    }
}
