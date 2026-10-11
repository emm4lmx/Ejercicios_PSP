package Ejercicio1a5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Realiza un programa que abra los siguientes procesos utilizando el mismo método para crear
 * cada uno de ellos:
 * - Abrir el intérprete de comandos mostrando la fecha del sistema.
 * - Abrir el intérprete de comandos mostrando la hora del sistema.
 * - Visualizar la información proporcionada por IPCONFIG.
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("FECHA DEL SISTEMA: ");
        ejecutarComando("cmd.exe", "/c", "date", "/t");

        System.out.println("HORA DEL SISTEMA: ");
        ejecutarComando("cmd.exe", "/c", "time", "/t");

        System.out.println("RESULTADO IPCONFIG: ");
        ejecutarComando("cmd.exe", "/c", "ipconfig");
    }

    /**
     * @description: Metodo para ejecutar comandos en cmd.exe
     * el metodo recibe un array de strings (String...)
     * @param comando
     */
    public static void ejecutarComando(String... comando) {
        ProcessBuilder pb = new ProcessBuilder(comando);
        try {
            Process p = pb.start();
            //leo la respuesta de la terminal
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;

            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            int codigo = p.waitFor();
            System.out.println("código de salida: " + codigo);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
