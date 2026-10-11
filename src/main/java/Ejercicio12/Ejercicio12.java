package Ejercicio12;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * Utilizando la clase ProcessBuilder, crea un programa en Java que:
 * 1. Pregunte al usuario por una aplicación con interfaz gráfica disponible en el sistema operativo actual.
 * 2. Abra la aplicación indicada.
 * 3. Obtenga y muestre la información del entorno asociada al proceso.
 *
 * Organiza la salida de forma legible, mostrando las variables del entorno como pares clave = valor.
 */

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //pido al usuario el nombre de la aplicación
        System.out.print("Aplicación a abrir: ");
        String app = entrada.nextLine();

        //creo el proceso con esa aplicación
        ProcessBuilder pb = new ProcessBuilder(app);

        try {
            //inicio el proceso
            Process p = pb.start();
            System.out.println("Abierta: " + app + " (PID: " + p.pid() + ")");

            //obtengo el mapa de variables de entorno del proceso
            Map<String, String> entorno = pb.environment();

            //muestro cuántas variables hay
            System.out.println("\n--- Variables de entorno (" + entorno.size() + ") ---");

            //recorro el mapa mostrando cada variable como "clave = valor"
            for (Map.Entry<String, String> e : entorno.entrySet()) {
                System.out.println(e.getKey() + " = " + e.getValue());
            }

        } catch (IOException e) {
            //si la aplicación no existe o no se puede abrir
            System.out.println("Error: " + e.getMessage());
        }

        entrada.close();
    }
}