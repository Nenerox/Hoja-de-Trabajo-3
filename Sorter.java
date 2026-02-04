public class Sorter<T extends comparable<T>> {
    public T[] GnomeSort(T[] input) {
        return input;
    }

    public T[] MergeSort(T[] input) {
        return input;
    }

    public T[] QuickSort(T[] input) {
        return input;
    }

    public T[] countSort(T[] input) {
        return input;
    }

    public T[] SeleccionSort(T[] input) {
        for (int i = 0; i < input.length; i++) {
            int min_id = i;
            
            for (int j = i + 1; j < input.length; j++) {
                if (input[j].compareTo(input[min_id]) < -1) {
                    min_id = j;
                }
            }

            T aux = input[i];
            input[i] = input[min_id];
            input[min_id] = aux;
        }
        return input;  
    }

}
