package Ejercicio11;

import java.io.IOException;

/**
 * Crea un programa en Java que, dependiendo del sistema operativo:
 *     - abra la calculadora en Windows;
 *     - abra Firefox en Ubuntu Linux.
 * Una vez creado el proceso, utiliza ProcessHandle para obtener y mostrar:
 *     - Nombre del comando.
 *     - Argumentos utilizados.
 *     - Tiempo de comienzo.
 *     - Tiempo de CPU.
 *     - Propietario.
 *     - Número de procesos hijos.
 */

public class Ejercicio11 {
    public static void main(String[] args) {

        String os = System.getProperty("os.name").toLowerCase();
        ProcessBuilder pb;

        //dependiendo de que sistema operativo sea, hace un proceso distinto
        if (os.contains("win")) {
            pb = new ProcessBuilder("calc.exe");

        } else {
            pb = new ProcessBuilder("firefox");
        }

        try {
            Process p = pb.start();
            Thread.sleep(1000); //espera 1s para que se actualize correctamente la informacion del sistema
            //convierto el processs a processhandle para poder consultar la informacion
            ProcessHandle ph = p.toHandle();
            //obtengo el bojeto con toda su informacion para mostrarla por pantalla
            ProcessHandle.Info info = ph.info();
            //orElse evita que haya errores en caso de que la informacion no esté disponible
            System.out.println("1. Comando: " + info.command().orElse("?"));
            System.out.println("2. Argumentos: " + info.arguments().map(a -> String.join(" ", a)).orElse("(ninguno)"));
            System.out.println("3. Inicio: " + info.startInstant().orElse(null));
            System.out.println("4. CPU: " + info.totalCpuDuration().orElse(null));
            System.out.println("5. Propietario: " + info.user().orElse("?"));
            System.out.println("6. Hijos: " + ph.children().count());

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

