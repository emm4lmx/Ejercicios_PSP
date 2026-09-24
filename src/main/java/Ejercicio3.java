import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("FECHA DEL SISTEMA: ");
        ejecutarComando("cmd.exe", "/c", "date", "/t");

        System.out.println("HORA DEL SISTEMA: ");
        ejecutarComando("cmd.exe", "/c", "time", "/t");

        System.out.println("RESULTADO IPCONFIG: ");
        ejecutarComando("ipconfig");
    }

    /**
     * @description: Metodo para ejecutar comandos en cmd.exe
     * @param comando
     */
    public static void ejecutarComando(String... comando) {
        ProcessBuilder pb = new ProcessBuilder(comando);
        try {
            Process p = pb.start();
            //leo la respuesta de la terminal
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;

            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            int codigo = p.waitFor();
            System.out.println("código de salida: " + codigo);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}
