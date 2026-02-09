import java.util.Arrays;

/**
 * Clase que implementa distintos algoritmos de sort
 * sobre arreglos genéricos de elementos.
 *
 * @param <T> Tipo de los elementos a ordenar
 */
public class Sorter<T extends Number & Comparable<T>> {

    /**
     * Ordena el arreglo utilizando el algoritmo Gnome Sort.
     *
     * @param input Arreglo de elementos a ordenar
     * @return El mismo arreglo ordenado en orden no decreciente
     *
     * @complexity Tiempo: O(n²) en el peor caso, Espacio: O(1)
     */
    public T[] GnomeSort(T[] input) {
        if (input.length == 0) {
            return input;
        }
        int index = 0;
        while (index < input.length) {
            if (index == 0 || input[index].compareTo(input[index - 1]) >= 0) {
                index++;
            } else {
                T temp = input[index];
                input[index] = input[index - 1];
                input[index - 1] = temp;
                index--;
            }
        }
        return input;
    }

    /**
     * Ordena el arreglo utilizando el algoritmo Merge Sort
     *
     * @param input Arreglo de elementos a ordenar
     * @return El mismo arreglo ordenado en orden no decreciente
     *
     *
     * @complexity Tiempo: O(n log n), Espacio: O(n)
     */
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

    /**
     * Ordena el arreglo utilizando el algoritmo Quick Sort
     *
     * @param arr Arreglo de elementos a ordenar
     * @return El mismo arreglo ordenado en orden no decreciente
     *
     *
     * @complexity Tiempo promedio: O(n log n), Peor caso: O(n²),
     *             Espacio: O(n)
     */
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

    /**
     * Ordena el arreglo utilizando el algoritmo Radix Sort
     * (base 10), soportando números positivos y negativos.
     *
     * @param input Arreglo de elementos a ordenar
     * @return Un nuevo arreglo con los elementos ordenados
     *
     * @complexity Tiempo: O(d · n), d es el número de dígitos,
     *             Espacio: O(n)
     */
    public T[] radixSort(T[] input) {
        if (input.length == 0) {
            return input;
        }

        int max = Math.abs(input[0].intValue());
        for (int i = 1; i < input.length; i++) {
            max = Math.max(max, Math.abs(input[i].intValue()));
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            T[] output = Arrays.copyOf(input, input.length);
            int[] count = new int[10];

            for (int i = 0; i < input.length; i++) {
                int digit = Math.abs(input[i].intValue() / exp) % 10;
                count[digit]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = input.length - 1; i >= 0; i--) {
                int digit = Math.abs(input[i].intValue() / exp) % 10;
                output[count[digit] - 1] = input[i];
                count[digit]--;
            }

            T[] temp = input;
            input = output;
            output = temp;
        }

        T[] result = Arrays.copyOf(input, input.length);
        int idx = 0;

        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i].intValue() < 0) {
                result[idx++] = input[i];
            }
        }

        for (T x : input) {
            if (x.intValue() >= 0) {
                result[idx++] = x;
            }
        }

        return result;
    }

    /**
     * Ordena el arreglo utilizando el algoritmo Selection Sort.
     *
     * @param input Arreglo de elementos a ordenar
     * @return El mismo arreglo ordenado en orden no decreciente
     *
     * @complexity Tiempo: O(n²), Espacio: O(1)
     */
    public T[] SeleccionSort(T[] input) {
        if (input.length == 0) {
            return input;
        }

        for (int i = 0; i < input.length; i++) {
            int minIndex = i;

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
