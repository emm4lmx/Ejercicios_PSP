package Ejercicio10;

import java.util.Scanner;

public class Hijo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //procesa numeros hasta que el usuario escribe FIN
        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();

            if (linea.equalsIgnoreCase("FIN")) {
                break;
            }

            try {
                int numero = Integer.parseInt(linea);

                //par o impar
                String paridad = (numero % 2 == 0) ? "par" : "impar";

                //positivo, negativo o 0
                String signo;
                if (numero > 0) {
                    signo = "positivo";
                } else if (numero < 0) {
                    signo = "negativo";
                } else {
                    signo = "cero";
                }

                //respuesta
                System.out.println(paridad + ", " + signo);
                System.out.flush(); //necesario para forzar la salida, sino se queda pillado

            } catch (NumberFormatException e) {
                System.out.println("ERROR: no es un número entero");
                System.out.flush();
            }
        }

        sc.close();
    }
}