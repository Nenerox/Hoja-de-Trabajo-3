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

        //GnomeSort TEST for unsorted and sorted
        System.out.println("Sorteando con GnomeSort");
        Integer[] SortedArray = sorter.GnomeSort(arrayToSort.clone());
        txtManager.writeResult("Sorted.txt", SortedArray);
        sorter.GnomeSort(SortedArray);

        //MergeSort TEST for unsorted and sorted
        System.out.println("Sorteando con MergeSort");
        SortedArray = sorter.MergeSort(arrayToSort.clone());
        txtManager.writeResult("Sorted.txt", SortedArray);
        sorter.MergeSort(SortedArray);

        //QuickSort TEST for unsorted and sorted
        System.out.println("Sorteando con QuickSort");
        SortedArray = sorter.QuickSort(arrayToSort.clone());
        txtManager.writeResult("Sorted.txt", SortedArray);
        sorter.QuickSort(SortedArray);

        //RadixSort TEST for unsorted and sorted
        System.out.println("Sorteando con RadixSort");
        SortedArray = sorter.radixSort(arrayToSort.clone());
        txtManager.writeResult("Sorted.txt", SortedArray);
        sorter.radixSort(SortedArray);

        //SeleccionSort TEST for unsorted and sorted
        System.out.println("Sorteando con SeleccionSort");
        SortedArray = sorter.SeleccionSort(arrayToSort.clone());
        txtManager.writeResult("Sorted.txt", SortedArray);
        sorter.SeleccionSort(SortedArray);

        System.out.println("Sorteo Terminado");

    }
}