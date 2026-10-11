package Ejercicio1a5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Realiza un programa que solicite por teclado una ruta y muestre el directorio indicado.
 * A continuación, debe pedir el nombre de una nueva carpeta y crearla dentro de dicho directorio.
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("introduce la ruta: ");
        String ruta = entrada.nextLine();

        System.out.println("Contenido del directorio: ");
        ejecutarComando("cmd.exe", "/c", "dir", ruta);

        System.out.println("introduce el nombre de la nueva carpeta: ");
        String nombre = entrada.nextLine();

        //construyo la ruta completa: ruta\nombre
        String rutaCompleta = ruta + "\\" + nombre;
        System.out.println("\nCreando carpeta: " + rutaCompleta);
        ejecutarComando("cmd.exe", "/c", "mkdir", rutaCompleta);
        System.out.println("Carpeta creada (o ya existente): " + rutaCompleta);

        entrada.close(); //cierro el scanner
    }

    /**
     * recibe un array de Strings (es como poner String[], a diferencia de que a la hora de ejecutarlo no hay que poner new String[]{"parametros"})
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
