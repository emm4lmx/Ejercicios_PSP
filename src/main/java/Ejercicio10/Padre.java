package Ejercicio10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Padre {

    public static void main(String[] args) {
        //consigo la ruta mediante classpath
        String classpath = System.getProperty("java.class.path");
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Ejercicio10.Hijo");

        try {
            Process hijo = pb.start();

            //flujo de comunicacion
            PrintWriter writer = new PrintWriter(hijo.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            Scanner sc = new Scanner(System.in);
            String linea;

            //bucle para enviar numeros al hijo
            do {
                System.out.print("Introduce un número entero (FIN para terminar): ");
                linea = sc.nextLine().trim();

                writer.println(linea);

                //mientras el usuario no escriba "FIN", el programa recibe la respuesta del hijo y la imprime por pantalla
                if (!linea.equalsIgnoreCase("FIN")) {
                    String respuesta = reader.readLine();
                    System.out.println("Respuesta: " + respuesta);
                }

            } while (!linea.equalsIgnoreCase("FIN"));

            //espera a que el hijo termine
            hijo.waitFor();
            System.out.println("Programa terminado.");
            sc.close();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}