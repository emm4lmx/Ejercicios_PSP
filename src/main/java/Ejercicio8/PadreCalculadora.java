package Ejercicio8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Crea dos programas Java: PadreCalculadora e HijoCalculadora.
 * El proceso padre pedirá al usuario una operación sencilla.
 * El padre enviará la operación al hijo mediante su entrada estándar. El hijo deberá calcular el
 * resultado y devolverlo por su salida estándar. El padre mostrará la respuesta.
 * El proceso debe admitir, al menos, suma, resta, multiplicación y división. La comunicación continuará hasta que el padre envíe la palabra FIN.
 */

public class PadreCalculadora {

    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Ejercicio8.HijoCalculadora");

        try {
            Process hijo = pb.start();

            PrintWriter writer = new PrintWriter(hijo.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(hijo.getInputStream())
            );

            Scanner entrada = new Scanner(System.in);
            String linea;

            do {
                System.out.print("Introduce operación (ej: 12 + 7) o FIN: ");
                linea = entrada.nextLine().trim();

                writer.println(linea);

                if (!linea.equalsIgnoreCase("FIN")) {
                    String respuesta = reader.readLine();
                    System.out.println("Resultado: " + respuesta);
                }

            } while (!linea.equalsIgnoreCase("FIN"));

            hijo.waitFor();
            System.out.println("Programa terminado.");
            entrada.close();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
