package Ejercicio1a5;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio5 {
    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");


        lanzador(classpath, new String[]{"java", "Ejercicios1a5.Ejercicio1"});
        //lanzador(ruta2, new String[]{"java", "Ejercicios1a5.Ejercicio3"});

    }
    public static void lanzador(String ruta, String[] cmd){
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.directory(new File(ruta));
        try {
            System.out.println("Lanzando '" + cmd + "' en: " + ruta);
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;

            while ((linea = reader.readLine()) != null) {
                System.out.println("HIJO:" + linea);
            }

            int codigo = p.waitFor();
            System.out.println("Proceso terminado con código: " + codigo);

        }catch (IOException | InterruptedException e){
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }
}
