package Ejercicio8;

import java.util.Scanner;

public class HijoCalculadora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();

            if (linea.equalsIgnoreCase("FIN")) {
                break;
            }

            try {
                //separo por espacios: "12 + 7" --> ["12", "+", "7"]
                String[] partes = linea.split("\\s+");

                if (partes.length != 3) {
                    System.out.println("ERROR: formato incorrecto");
                    System.out.flush();
                    continue;
                }

                double num1 = Double.parseDouble(partes[0]);
                String operador = partes[1];
                double num2 = Double.parseDouble(partes[2]);

                double resultado = 0;
                boolean valido = true;

                switch (operador) {
                    case "+": resultado = num1 + num2; break;
                    case "-": resultado = num1 - num2; break;
                    case "*": resultado = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("ERROR: división por cero");
                            valido = false;
                        } else {
                            resultado = num1 / num2;
                        }
                        break;
                    default:
                        System.out.println("ERROR: operador no válido");
                        valido = false;
                }

                if (valido) {
                    //si es entero, mostrar sin decimales
                    if (resultado == (long) resultado) {
                        System.out.println((long) resultado);
                    } else {
                        System.out.println(resultado);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: número no válido");
            }

            System.out.flush(); //necesario para forzar la salida
        }
        sc.close(); //cierro el scanner
    }
}