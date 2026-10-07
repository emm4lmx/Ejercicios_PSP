package Ejercicio1a5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("introduce la ruta: ");
        String ruta = entrada.nextLine();

        System.out.println("Contenido del directorio: ");
        ejecutarComando("cmd.exe", "/c", "dir", ruta);

        System.out.println("introduce el nombre de la nueva carpeta: ");
        String nombre = entrada.nextLine();

        String rutaCompleta = ruta + "\\" + nombre;
        ejecutarComando("cmd.exe", "/c", "mkdir", rutaCompleta);
    }

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
