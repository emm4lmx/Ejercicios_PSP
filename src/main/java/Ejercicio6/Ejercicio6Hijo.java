package Ejercicio6;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio6Hijo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Random random = new Random();

        while (entrada.hasNextLine()) {
            String mensaje = entrada.nextLine().trim();
            if (mensaje.equalsIgnoreCase("NO")){
                break;
            }
            //genero un numero random
            int numeroRandom = random.nextInt(100000); // Genera entre 0 y 99.999
            System.out.println(numeroRandom);
            //fuerza la salida
            System.out.flush();

        }
        System.out.println("termina");
        entrada.close();
    }
}