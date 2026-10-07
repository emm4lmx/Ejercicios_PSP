package Ejercicio7;

import java.util.Scanner;

public class Ejercicio7Mayusculas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);


        while (entrada.hasNextLine()) {
            String linea = entrada.nextLine();
            if (linea.equalsIgnoreCase("FIN")){
                break;
            }

            System.out.println(linea.toUpperCase());

            //fuerza la salida
            System.out.flush();
        }
        entrada.close();
    }
}