import java.util.Arrays;

public class Sorter<T extends Number & Comparable<T>> {
    public T[] GnomeSort(T[] input) {
        if (input.length == 0) {
            return input;
        }        
        int index = 0;
        while (index < input.length) {
            if (index == 0 || input[index].compareTo(input[index - 1]) >= 0) {
                index++;
            } else {
                // Intercambiar elementos
                T temp = input[index];
                input[index] = input[index - 1];
                input[index - 1] = temp;
                index--;
            }
        }
        return input;
    }
    public T[] MergeSort(T[] input) {
        int n = input.length;
        if (n <= 1) return input;
        T[] aux = Arrays.copyOf(input, n);
        for (int size = 1; size < n; size *= 2) {
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                for (int i = left; i <= right; i++) {
                    aux[i] = input[i];
                }
                int i = left;
                int j = mid + 1;
                int k = left;
                while (i <= mid && j <= right) {
                    if (aux[i].compareTo(aux[j]) <= 0) {
                        input[k++] = aux[i++];
                    } else {
                        input[k++] = aux[j++];
                    }
                }
                while (i <= mid) {
                    input[k++] = aux[i++];
                }
            }
        }
        return input;
    }

    public T[] QuickSort(T[] arr) {
        int n = arr.length;
        if (n <= 1) return arr;

        int[] stack = new int[n * 2];
        int top = -1;
        stack[++top] = 0;
        stack[++top] = n - 1;
        while (top >= 0) {
            int high = stack[top--];
            int low = stack[top--];
            T pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j].compareTo(pivot) <= 0) {
                    i++;
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            T temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            int p = i + 1;
            if (p - 1 > low) {
                stack[++top] = low;
                stack[++top] = p - 1;
            }
            if (p + 1 < high) {
                stack[++top] = p + 1;
                stack[++top] = high;
            }
        }
        return arr;
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
            
            // Buscar el mínimo en arreglo no ordenado y colocarlo al inicio
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