package Ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Padre {

    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Ejercicio9.Hijo");


        try {
            Process hijo = pb.start();

            PrintWriter writer = new PrintWriter(hijo.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            Scanner sc = new Scanner(System.in);
            String linea;

            do {
                System.out.print("Introduce frase (FIN para terminar): ");
                linea = sc.nextLine();

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
            sc.close(); //cierro el scanner

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}