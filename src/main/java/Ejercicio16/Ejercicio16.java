package Ejercicio16;

import java.io.IOException;

/**
 * Crea un programa que:
 * 1. Abra una aplicación recibida mediante los argumentos del programa (String[] args), por ejemplo Notepad en Windows o gedit en Linux.
 * 2. Mantenga la aplicación abierta durante 10 segundos.
 * 3. Transcurrido ese tiempo, cierre el proceso mediante código. El usuario no debe cerrar manualmente la aplicación.
 * 4. Una vez cerrada, espere 5 segundos.
 * 5. Finalmente, muestre por pantalla: Buenas noches amigo!
 */
public class Ejercicio16 {
    public static void main(String[] args) {
        //si no se pasa ningún argumento, usamos "notepad.exe" por defecto
        String app = args.length > 0 ? args[0] : "notepad.exe";

        ProcessBuilder pb = new ProcessBuilder(app);

        try {
            //abre la aplicación
            System.out.println("Abriendo " + app + "...");
            Process p = pb.start();

            //espera 10 segundos (10000 ms)
            System.out.println("Esperando 10 segundos...");
            Thread.sleep(10000);

            //cierra el proceso por código
            System.out.println("Cerrando " + app + "...");
            p.destroy();

            //espera 5 segundos
            System.out.println("Esperando 5 segundos...");
            Thread.sleep(5000);

            //muestra el mensaje final
            System.out.println("Buenas noches amigo!");

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}