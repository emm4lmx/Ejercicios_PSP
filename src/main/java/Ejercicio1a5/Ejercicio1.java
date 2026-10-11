package Ejercicio1a5;

import java.io.IOException;

/**
 * Crea un programa que genere un proceso capaz de abrir Notepad y cargar un documento llamado tuNombre.txt.
 * El programa a ejecutar (Notepad) y el nombre del fichero deben recibirse mediante argumentos del programa.
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        String programa = args[0];
        String nombre = args[1];

        ProcessBuilder pb = new ProcessBuilder(programa, nombre);

        try {
            //hasta que no haya un start no se ejecuta
            Process proceso = pb.start();
            //muestro por pantalla el id del proceso que se ha iniciado
            System.out.println("PID: " + proceso.pid());

        } catch (IOException e) {
            System.err.println("no se pudo iniciar el proceso: " + e);
        }
    }
}

