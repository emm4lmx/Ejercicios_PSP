package Ejercicio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

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
                printWriter.println("DAME");
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