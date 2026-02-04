import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
/**
 * Clase utilitaria para la lectura y escritura de archivos de texto.
 *
 * Permite leer expresiones desde un archivo y escribir
 * el resultado final de la calculadora.
 */
public class txtManager {

    /**
     * Lee el contenido de un archivo y lo separa por espacios.
     * @param filePath ruta del archivo a leer
     */
    public int[] getArray(String filePath) {
    try {
        String[] stringArray = Files.readString(Path.of(filePath)).trim().split(" ");
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;

    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
        return new int[0];
    }
}

    /**
     * Escribe el resultado final en un archivo de texto.
     *
     * @param filePath ruta del archivo de salida
     * @param result resultado a escribir
     */
    public void writeResult(String filePath, int[] result) {
        try {
            Files.writeString(
                Path.of(filePath),
                java.util.Arrays.toString(result) + " ",
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}