package Ejercicio15;

import java.io.IOException;

/**
 * Crea un programa que lance un proceso hijo y, justo después de crearlo, haga que el proceso
 * padre espere a que el hijo termine antes de continuar con la generación de números aleatorios.
 * Observa y explica qué ocurre al ejecutar el programa.
 * Por último, obtén y muestra el valor de salida del proceso hijo. Utiliza los mecanismos de
 * espera y consulta del valor de finalización estudiados en este apartado.
 */
public class Ejercicio15 {
    public static void main(String[] args) {
        //prepara el comando: abre el Notepad
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");

        try {
            //lanza el proceso
            System.out.println("Lanzando Notepad...");
            Process p = pb.start();

            //el padre espera hasta que el hijo termine (cuando cierre Notepad)
            System.out.println("Padre esperando...");
            p.waitFor();

            //obtiene el código de salida
            int codigo = p.exitValue();
            System.out.println("Notepad cerrado. Código de salida: " + codigo);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}