import java.util.Arrays;

public class Sorter<T extends Number & Comparable<T>> {
    public T[] GnomeSort(T[] input) {
        return input;
    }

    public T[] MergeSort(T[] input) {
        return input;
    }

    public T[] QuickSort(T[] input) {
        return input;
    }

    public T[] radixSort(T[] input) {
        if (input.length == 0) {
            return input;
        }

        //Encontrar el valor maximo absoluto para determinar el numero de digitos
        int max = Math.abs(input[0].intValue());
        for (int i = 1; i < input.length; i++) {
            max = Math.max(max, Math.abs(input[i].intValue()));
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            T[] output = Arrays.copyOf(input, input.length);
            int[] count = new int[10];

            //Contar ocurrencias de cada digito
            for (int i = 0; i < input.length; i++) {
                int digit = Math.abs(input[i].intValue() / exp) % 10;
                count[digit]++;
            }

            //Modificar count para que tenga posiciones reales
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            //Crear el array ordenado por digitos
            for (int i = input.length - 1; i >= 0; i--) {
                int digit = Math.abs(input[i].intValue() / exp) % 10;
                output[count[digit] - 1] = input[i];
                count[digit]--;
            }

            //Intercambiar array para que input tenga el resultado antes de acomodar negativos
            T[] temp = input;
            input = output;
            output = temp;
        }

        //Acomodar negativos y positivos
        T[] result = Arrays.copyOf(input, input.length);
        int idx = 0;

        //Negativos con el orden invertido -10 < -1
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i].intValue() < 0) {
                result[idx++] = input[i];
            }
        }

        //Positivos con el orden normal 10 > 1
        for (T x : input) {
            if (x.intValue() >= 0) {
                result[idx++] = x;
            }
        }

        return result;
    }

    public T[] SeleccionSort(T[] input) {
        if (input.length == 0) {
            return input;
        }

        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            
            //Buscar el minimo en el arreglo no ordenado y colocarlo al inicio
            for (int j = i + 1; j < input.length; j++) {
                if (input[j].compareTo(input[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            T aux = input[i];
            input[i] = input[minIndex];
            input[minIndex] = aux;
        }
        return input;  
    }

}
