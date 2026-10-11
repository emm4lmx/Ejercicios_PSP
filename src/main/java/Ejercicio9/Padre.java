package Ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Crea un proceso hijo que reciba líneas de texto y, por cada línea recibida, devuelva tres datos:
 * - número de caracteres;
 * - número de palabras;
 * - número de vocales.
 * El proceso padre pedirá frases al usuario, las enviará al hijo y mostrará la respuesta recibida.
 * La ejecución finalizará cuando el usuario introduzca FIN.
 */

public class Padre {

    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Ejercicio9.Hijo");


        try {
            Process hijo = pb.start();

            PrintWriter writer = new PrintWriter(hijo.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            Scanner entrada = new Scanner(System.in);
            String linea;

            do {
                System.out.print("Introduce frase (FIN para terminar): ");
                linea = entrada.nextLine();

                //le paso al hijo lo que escribe el usuario
                writer.println(linea);

                //si el usuario cualquier cosa distinta de "FIN", recibo la respuesta del hijo y la muestro por pantalla
                if (!linea.equalsIgnoreCase("FIN")) {
                    String respuesta = reader.readLine();
                    System.out.println("Respuesta: " + respuesta);
                }

            } while (!linea.equalsIgnoreCase("FIN"));

            //espero a que el hijo acabe
            hijo.waitFor();
            System.out.println("Programa terminado.");
            entrada.close(); //cierro el scanner

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}