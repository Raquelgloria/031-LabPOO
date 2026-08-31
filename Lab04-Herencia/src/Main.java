/*RAQUEL GUADALUPE GLORIA VAZQUEZ   #2011258
LABORATORIO DE PROGRAMACIÓN ORIENTADA A OBJETOS  GPO 031
PRACTICA 4 HERENCIA */


public class Main {
    public static void main(String[] args) {
        Mago mago = new Mago("Gandalf", 10, 100, 20, "Fuego");
        Arquero arquero = new Arquero("Legolas", 8, 80, 15,  "Arco Largo");
        Guerrero guerrero = new Guerrero("Conan", 12, 120, 40, "Armadura de Hierro");


        System.out.println("----Ataque----");
        mago.atacar();
        arquero.atacar();
        guerrero.atacar();



        System.out.println("----Defensa----");
        mago.defender();
        arquero.defender();
        guerrero.defender();

        
        System.out.println("\n----DAÑO RECIBIDO----:");
        
        mago.recibirDanio(30);
        arquero.recibirDanio(20);   
        guerrero.recibirDanio(25);

        System.out.println("\n---- Estado final ----");
        System.out.println(mago);
        System.out.println(arquero);
        System.out.println(guerrero);   
    
        
    }

}
