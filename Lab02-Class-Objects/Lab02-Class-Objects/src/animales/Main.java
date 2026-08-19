/*RAQUEL GUADALUPE GLORIA VAZQUEZ #2011258
LABORATORIO DE POO 
PRACTICA #2 CLASES Y OBJETOS */

public class Main {
    
    public static void main(String[] args) {

        System.out.println("-- CLINICA VETERINARIA ---");
        System.out.println("-- PERRO---");
        Perro perro = new Perro("Dogo", 12, 15.5, "Terry Escoces", true);
        perro.ladrar();
        perro.buscarPelota();

        System.out.println(perro.toString());

        System.out.println("-- GATO ---");
        Gato gato = new Gato("Romualdo", 5, 4.2, "Gris", true);
        gato.maullar();
        gato.ronrronear();
        System.out.println(gato.toString());

        System.out.println("-- CANARIO ---");
        Canario canario = new Canario("Piolin", 2, 0.5, "Amarillo", true);
        canario.cantar();
        canario.volar();
        System.out.println(canario.toString());

    }

}
