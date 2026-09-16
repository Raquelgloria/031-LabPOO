/*RAQUEL GUADALUPE GLORIA VAZQUEZ   #2011258
LABORATORIO DE PROGRAMACIÓN ORIENTADA A OBJETOS  GPO 031
PRACTICA 6 clases abstractas e interfaces */


public class Main {
    public static void main(String[] args) {
        // Personaje personaje = new Personaje("Personaje", 1, 100);
        // Error de compilacion: Personaje es una clase abstracta.

        Druida druida = new Druida("Lunara", 10, 120, 25, 20, "Lobo");
        Nigromante nigromante = new Nigromante("Morthos", 9, 100, 30, 5, 3);
        Bardo bardo = new Bardo("Orfeo", 8, 90, 15, "Laud", 12);

        Personaje[] equipo = { druida, nigromante, bardo };
        for (Personaje p : equipo) {
            p.atacar();
            System.out.println("Daño: " + p.calcularDanio());
        }

        for (Personaje p : equipo) {
            if (p instanceof Hechicero h) {
                h.lanzarHechizo();
            }
            if (p instanceof Sanador s) {
                s.curarAliado(nigromante);
            }
        }

        nigromante.recibirDanio(60);
        System.out.println("Vida del Nigromante despues del daño: " + nigromante.getPuntosVida());

        druida.curarAliado(nigromante);
        System.out.println("Vida despues de la curacion del Druida: " + nigromante.getPuntosVida());

        bardo.curarAliado(nigromante);
        System.out.println("Vida despues de la curacion del Bardo: " + nigromante.getPuntosVida());
    }
}
