import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe", "emma.txt");
        try {
            //hasta que no haya un start no se ejecuta
            Process proceso = pb.start();
            //muestro por pantalla el id del proceso que se ha iniciado
            System.out.println("PID: " + proceso.pid());

        } catch (IOException e) {
            System.err.println("no se pudo iniciar el proceso: " + e);
        }
    }
}

