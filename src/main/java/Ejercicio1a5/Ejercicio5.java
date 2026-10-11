package Ejercicio1a5;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Realiza un método llamado lanzador que reciba como argumentos una ruta y un comando,
 * y ejecute el programa descrito por dicho comando en la ruta especificada.
 * Desde el programa principal, prueba el método lanzador con dos programas diferentes.
 * Puedes reutilizar programas empleados en los ejercicios anteriores.
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");


        lanzador(classpath, new String[]{"java", "Ejercicio1a5.Ejercicio1"});
        lanzador(classpath, new String[]{"java", "Ejercicio1a5.Ejercicio3"});

    }
    public static void lanzador(String ruta, String[] cmd){
        //creo el proceso
        ProcessBuilder pb = new ProcessBuilder(cmd);
        //le indico en que carpeta ejecutarlo
        pb.directory(new File(ruta));
        try {
            System.out.println("Lanzando '" + cmd + "' en: " + ruta);
            //inicio el proceso
            Process p = pb.start();
            //leo la salida del hijo
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;

            while ((linea = reader.readLine()) != null) {
                System.out.println("HIJO:" + linea);
            }

            //espero a que termine
            int codigo = p.waitFor();
            System.out.println("Proceso terminado con código: " + codigo);

        }catch (IOException | InterruptedException e){
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }
}
