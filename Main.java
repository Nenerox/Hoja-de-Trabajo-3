import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        
        int cantidadNumeros = random.nextInt(2991) + 10; // 2991 = 3000 - 10 + 1
        
        String nombreArchivo = "numeros_aleatorios_" + System.currentTimeMillis() + ".txt";
        
        generarNumeros(cantidadNumeros, nombreArchivo, random);
    }
    
    private static void generarNumeros(int cantidad, String nombreArchivo, Random random) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < cantidad; i++) {
                int numero = random.nextInt();
                writer.print(numero);
                if(i < cantidad - 1)
                {
                    writer.print(" ");
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}