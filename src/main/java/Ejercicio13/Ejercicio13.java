package Ejercicio13;

import java.io.File;
import java.io.IOException;

/**
 * Utilizando la clase ProcessBuilder, ejecuta el comando: CMD /c ver
 * Redirige:
 * - la salida estándar a un fichero llamado salida.txt;
 * - la salida de error a un fichero llamado error.txt.
 * Para ello, utiliza los métodos redirectOutput() y redirectError() de ProcessBuilder.
 * A continuación, ejecuta un comando que no exista, por ejemplo: CMD /c verr
 * Comprueba qué información se almacena en cada fichero y explica brevemente el resultado.
 */
public class Ejercicio13 {
    public static void main(String[] args) {

        //comando que si existe ("ver" muestra la versión de Windows)
        ProcessBuilder pb1 = new ProcessBuilder("cmd.exe", "/c", "ver");

        //redirige la salida normal (stdout) al fichero salida.txt
        pb1.redirectOutput(new File("salida.txt"));

        //redirige los errores (stderr) al fichero error.txt
        pb1.redirectError(new File("error.txt"));

        try {
            //lanza el proceso y espera a que termine
            pb1.start().waitFor();
            System.out.println("Caso 1 ejecutado. Revisa salida.txt y error.txt");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //comando que no existe ("verx" no es válido, dará error)
        ProcessBuilder pb2 = new ProcessBuilder("cmd.exe", "/c", "verx");

        //redirige la salida normal a salida2.txt
        pb2.redirectOutput(new File("salida2.txt"));

        //redirige los errores a error2.txt
        pb2.redirectError(new File("error2.txt"));

        try {
            //lanza el proceso y espera a que termine
            pb2.start().waitFor();
            System.out.println("Caso 2 ejecutado. Revisa salida2.txt y error2.txt");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}