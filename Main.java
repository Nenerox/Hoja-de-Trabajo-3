import java.util.Random;

public class Main {
    public static void main(String[] args) {
        txtManager txtManager = new txtManager();
        Random random = new Random();
        
        int cantidadNumeros = random.nextInt(2991) + 10; // 2991 = 3000 - 10 + 1
        
        String nombreArchivo = "Unsorted.txt";
        
        txtManager.generarNumeros(cantidadNumeros, nombreArchivo, random);
    }
}