/*RAQUEL GUADALUPE GLORIA VAZQUEZ   #2011258
LABORATORIO DE PROGRAMACIÓN ORIENTADA A OBJETOS  GPO 031
PRACTICA 5 POLIMORFISMO */


public class Main {
    public static void main(String[] args) {
        Personaje p1= new Mago("Gandalf", 10, 100, 20, "Fuego");
        Personaje p2 = new Arquero("Legolas", 8, 80, 15,  "Arco Largo");
        Personaje p3 = new Guerrero("Conan", 12, 120, 40, "Armadura de Hierro");

        System.out.println(p1.calcularDanio()); // ejecuta el de Guerrero
        System.out.println(p2.calcularDanio()); // ejecuta el de Mago
        System.out.println(p3.calcularDanio());

        Personaje[] equipo = { p3, p1, p2 };
        for (Personaje p : equipo) {
            System.out.println(p.getNombre() + " daño " + p.calcularDanio()); 
        }

        GestorBatalla gestor = new GestorBatalla();
        gestor.ejecutarAtaque(p1);
        gestor.ejecutarAtaque(p2, p3);
        gestor.ejecutarAtaque(equipo);

        gestor.mostrarHistorial();
        gestor.limpiarHistorial();

        for (Personaje p : equipo) {
            if (p instanceof Guerrero) {
                System.out.println(p.getNombre() + " es un Guerrero.");
            } else if (p instanceof Mago) {
                System.out.println(p.getNombre() + " es un Mago.");
            } else if (p instanceof Arquero) {
                System.out.println(p.getNombre() + " es un Arquero.");
            }
    }
        
    }

}
