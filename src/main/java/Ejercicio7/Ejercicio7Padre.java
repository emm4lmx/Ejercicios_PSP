package Ejercicio7;

import java.io.*;
import java.util.Scanner;

public class Ejercicio7Padre {
    public static void main(String[] args) {

        String classpath = System.getProperty("java.class.path");
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Ejercicio7.Ejercicio7Mayusculas");
        Scanner entrada = new Scanner(System.in);

        try {
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            PrintWriter printWriter = new PrintWriter(p.getOutputStream(), true);
            String linea;

            do {
                System.out.print("introduce el mensaje que quieres modificar: ");
                linea = entrada.nextLine();
                printWriter.println(linea);
                String mensajeModificado = reader.readLine();
                System.out.println("Mensaje modificado: " + mensajeModificado);

                //System.out.print("que otro mensaje quieres modificar: ");

            } while (!linea.equalsIgnoreCase("FIN"));


            printWriter.println("FIN");

            System.out.println("esperando a que acabe el proceso hijo...");
            p.waitFor();
            System.out.println("proceso acabado");

            entrada.close();

        } catch (IOException | InterruptedException e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }
}
