package Ejercicio14;

/**
 * Crea un programa en Java que imprima el mensaje: ¿Qué pasa?
 * diez veces, esperando un segundo entre cada impresión.
 */
public class Ejercicio14 {
    public static void main(String[] args) {
        //bucle que se repite 10 veces
        for (int i = 0; i < 10; i++) {
            //imprime el mensaje con el número de vez
            System.out.println((i + 1) + ". ¿Qué pasa?");

            try {
                //pausa el programa 1000 milisegundos (1 segundo)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //si algo interrumpe la pausa, muestra el error
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}