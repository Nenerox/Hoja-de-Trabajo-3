import java.util.Random;

public class Main {
    public static void main(String[] args) {
        txtManager txtManager = new txtManager();
        Random random = new Random();
        Sorter<Integer> sorter = new Sorter<>();

        int cantidadNumeros = random.nextInt(2991) + 10; // 2991 = 3000 - 10 + 1
        txtManager.generarNumeros(cantidadNumeros, "Unsorted.txt", random);

        System.out.println("Cantidad de numeros a sortear: " + cantidadNumeros);
         
        Integer[] arrayToSort = txtManager.getArray("Unsorted.txt");

        //GnomeSort TEST unsorted and sorted
        System.out.println("Sorteando con GnomeSort");
        txtManager.writeResult("Sorted.txt", sorter.GnomeSort(arrayToSort));
        Integer[] SortedArray = txtManager.getArray("Sorted.txt");
        sorter.GnomeSort(SortedArray);

        //MergeSort TEST unsorted and sorted
        System.out.println("Sorteando con MergeSort");
        txtManager.writeResult("Sorted.txt", sorter.MergeSort(arrayToSort));
        SortedArray = txtManager.getArray("Sorted.txt");
        sorter.MergeSort(SortedArray);

        //QuickSort TEST unsorted and sorted
        System.out.println("Sorteando con QuickSort");
        txtManager.writeResult("Sorted.txt", sorter.QuickSort(arrayToSort));
        SortedArray = txtManager.getArray("Sorted.txt");
        sorter.QuickSort(SortedArray);

        //RadixSort TEST unsorted and sorted
        System.out.println("Sorteando con RadixSort");
        txtManager.writeResult("Sorted.txt", sorter.radixSort(arrayToSort));
        SortedArray = txtManager.getArray("Sorted.txt");
        sorter.radixSort(SortedArray);

        //SeleccionSort TEST unsorted and sorted
        System.out.println("Sorteando con SeleccionSort");
        txtManager.writeResult("Sorted.txt", sorter.SeleccionSort(arrayToSort));
        SortedArray = txtManager.getArray("Sorted.txt");
        sorter.SeleccionSort(SortedArray);

        System.out.println("Sorteo Terminado");

    }
}