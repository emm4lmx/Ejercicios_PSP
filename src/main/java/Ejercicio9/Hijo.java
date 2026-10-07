package Ejercicio9;

import java.util.Scanner;

public class Hijo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();

            if (linea.equalsIgnoreCase("FIN")) {
                break;
            }

            //número de caracteres (longitud total)
            int caracteres = linea.length();

            //número de palabras (separadas por espacios)
            String[] palabras = linea.trim().split("\\s+");
            String respuesta = getString(linea, palabras, caracteres);

            System.out.println(respuesta);
            System.out.flush(); //necesario para forzar la salida del programa
        }

        sc.close(); //cierro el scanner
    }

    private static String getString(String linea, String[] palabras, int caracteres) {
        int numPalabras = linea.trim().isEmpty() ? 0 : palabras.length;

        //número de vocales (a, e, i, o, u, con o sin tilde)
        int vocales = 0;
        String minusculas = linea.toLowerCase();
        //bucle que va sumando a una variable que cuenta las vocales
        for (int i = 0; i < minusculas.length(); i++) {
            char c = minusculas.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú'
                    || c == 'ü') {
                vocales++;
            }
        }

        //construyo la respuesta
        String respuesta = "caracteres=" + caracteres + "; palabras=" + numPalabras + "; vocales=" + vocales;
        return respuesta;
    }
}