package Ejercicio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Crea un proceso hijo encargado de generar números de lotería: un número aleatorio comprendido entre 0 y 99999.
 * Cada vez que reciba una petición del proceso padre, el hijo escribirá el número generado en su salida estándar.
 * Crea además un proceso padre que solicite sucesivamente al hijo un nuevo número. El proceso terminará cuando el usuario indique que no desea otro número,
 * respondiendo NO a la pregunta correspondiente.
 */
public class Ejercicio6Padre {
    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Ejercicio6.Ejercicio6Hijo");


        try {
            Process p = pb.start();

            PrintWriter printWriter = new PrintWriter(p.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            Scanner entrada = new Scanner(System.in);
            String respuesta;

            do {
                printWriter.println("SI");
                String numero = bufferedReader.readLine();
                System.out.println("NUMERO DE LOTERIA: " + numero);

                System.out.println("quieres otro numero?");
                respuesta = entrada.nextLine().trim();

            } while (!respuesta.equalsIgnoreCase("NO"));

            //le paso al hijo "NO" para que se detenga la ejecución
            printWriter.println("NO");

            System.out.println("esperando a que acabe el programa...");
            p.waitFor();
            System.out.println("programa terminado");


            entrada.close();


        } catch (IOException | InterruptedException e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }
}