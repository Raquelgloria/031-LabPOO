/*RAQUEL GUADALUPE GLORIA VAZQUEZ   #2011258
LABORATORIO DE PROGRAMACIÓN ORIENTADA A OBJETOS  GPO 031
PRACTICA 8 COLECCIONES */


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

        // bloque 1
        GestionGremio gremio = new GestionGremio();
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100, 30));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 120, 10));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, 95, "Arco"));
        gremio.agregarMiembro(new Guerrero("Thorin", 9, 400, 80, "Hacha"));
        gremio.mostrarRoster();

        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        Personaje encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null)
            System.out.println("Encontrado: " + encontrado.getNombre());

        // bloque 2
        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();

        gremio.atenderSiguiente();   // atiende a Gandalf (FIFO)
        gremio.mostrarCola();

        // bloque 3

        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);  // suma → 8

        gremio.mostrarInventario();

        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");    // no existe
        gremio.mostrarInventario();

        //bloque 4
        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");    // duplicado — no se agrega

        gremio.mostrarHabilidades();

        System.out.println("¿Tiene flecha? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curación? " + gremio.tieneHabilidad("Curación"));


        // bloque 5
        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }

}
