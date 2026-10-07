/*RAQUEL GUADALUPE GLORIA VAZQUEZ   #2011258
LABORATORIO DE PROGRAMACIÓN ORIENTADA A OBJETOS  GPO 031
PRACTICA 7-8 EXCEPCIONES /COLECCIONES
PRACTICA 9 Entrada/Salida (I/O) en Java */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        //de la parctica 7 excepciones
        MotorCombate motor = new MotorCombate();
        motor.ejecutarTurno(druida, nigromante);

        druida.recibirDanio(9999);
        motor.ejecutarTurno(druida, nigromante);  // captura PersonajeDerrotadoException

        Arquero sinFlechas = new Arquero("Legolas", 6, 150, 0, "Arco Largo");
        motor.ejecutarTurno(sinFlechas, nigromante);  // captura RecursoInsuficienteException

        Druida druida2 = new Druida("Druida 2", 5, 100, 20, 10);
        Personaje personajeDerrotado = new Guerrero("Guerrero Caido", 3, 10, 5, "Escudo");
        personajeDerrotado.recibirDanio(20);

        try {
            druida2.curarAliado(personajeDerrotado);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        motor.mostrarBitacora();


        //practica 8 colecciones
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


        /*PRACTICA 9 (IO) ENTRADA Y SALIDA */

        try {
            /*BLOQUE 1 */
            PersistenciaGremio persistencia = new PersistenciaGremio();
            ArrayList<Personaje> roster = new ArrayList<>();
            roster.add(new Druida("Sylva", 10, 300, 100, 30));
            roster.add(new Arquero("Legolas", 6, 150, 95, "Arco"));
            roster.add(new Guerrero("Thorin", 9, 400, 80, "Hacha"));

            persistencia.guardarRoster(roster);

            /*BLOQUE 2 */
            ArrayList<String> lineasRoster = persistencia.cargarRoster();
            System.out.println("\n=== Roster cargado desde archivo ===");
            for (String linea : lineasRoster) {
                String[] partes = linea.split(",");
                System.out.println("Nombre: " + partes[0] +
                       " | Nivel: " + partes[1] +
                       " | Vida: " + partes[2]);
            }   

        /*BLOQUE 3 */
        HashMap<String, Integer> inventario = new HashMap<>();
        inventario.put("Poción de vida", 8);
        inventario.put("Flecha élfica", 30);
        inventario.put("Pergamino de fuego", 3);

        persistencia.guardarInventario(inventario);

        HashMap<String, Integer> inventarioCargado =
            persistencia.cargarInventario();

        System.out.println("\n=== Inventario cargado desde archivo ===");
        for (Map.Entry<String, Integer> e : inventarioCargado.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
       } 

       /*BLOQUE 4 */
        persistencia.agregarEntradaBitacora("Sylva atacó a Malachar (daño: 240)");
        persistencia.agregarEntradaBitacora("Legolas sin flechas — no pudo atacar");
        persistencia.agregarEntradaBitacora("Thorin venció a Dragón de Hielo");

        persistencia.mostrarBitacora();

       /*BLOQUE 5 */
       File carpeta = new File("datos_gremio");
       System.out.println("\n=== Archivos en datos_gremio/ ===");
       for (File f : carpeta.listFiles()) {
        System.out.println(f.getName() +
        " (" + f.length() + " bytes)");
       }
    
        } catch (IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        }
    }

}
