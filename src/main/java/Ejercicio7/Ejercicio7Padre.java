package Ejercicio7;

import java.io.*;
import java.util.Scanner;

/**
 * Crea un proceso hijo llamado Mayusculas que reciba desde un proceso padre una línea de texto y devuelva dicho texto convertido a mayúsculas.
 * El proceso padre:
 * - Leerá una línea de texto introducida por el usuario.
 * - Enviará dicha línea a la entrada estándar del hijo utilizando el flujo de salida asociado al proceso.
 * - Leerá la respuesta del hijo.
 * - Mostrará en pantalla el texto recibido.
 * La comunicación entre padre e hijo será bidireccional mediante streams.
 */
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
                //envio la respuesta al hijo
                printWriter.println(linea);

                //solo leo la respuesta si no es FIN
                if (!linea.equalsIgnoreCase("FIN")) {
                    String mensajeModificado = reader.readLine();
                    System.out.println("Mensaje modificado: " + mensajeModificado);
                }

            } while (!linea.equalsIgnoreCase("FIN"));


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
