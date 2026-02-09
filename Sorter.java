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
        if (input.length == 0) {
            return input;
        }

        if (input.length <= 1) return input;
        T[] aux = Arrays.copyOf(input, input.length);
        sort(input, aux, 0, input.length - 1);
        return input;
    }
    //El codigo se separa en metodos privados para ejecutarlo más facil
    private void sort(T[] arr, T[] aux, int left, int right) {
        //Este metodo divide el input en dos, ordena la parte izquierda y la parte derecha, y luego
        // los hace merge llamando a otro metodo privado
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(arr, aux, left, mid);
        sort(arr, aux, mid + 1, right);
        merge(arr, aux, left, mid, right);
    }
    //este metodo privado hace merge los lados izquierdo y derecho ya ordenados
    private void merge(T[] arr, T[] aux, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            aux[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (aux[i].compareTo(aux[j]) <= 0) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = aux[i++];
        }
    }

    public T[] QuickSort(T[] input) {
        if (input.length == 0) {
            return input;
        }

        quickSort(input, 0, input.length - 1);
        return input;
    }
    //Este metodo divide el input usando un pivote, y lo va ordenando recursivamente, usa el otro método
    //privado para dividirlo y el metodo swap para ir intercambiando los valores recursivamente
    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }
    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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