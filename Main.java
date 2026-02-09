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
        Integer[] SortedArray = sorter.GnomeSort(arrayToSort);
        txtManager.writeResult("Sorted.txt", SortedArray);
        sorter.GnomeSort(SortedArray);

        //MergeSort TEST unsorted and sorted
        System.out.println("Sorteando con MergeSort");
        SortedArray = sorter.MergeSort(arrayToSort);
        txtManager.writeResult("Sorted.txt", SortedArray);
        sorter.MergeSort(SortedArray);

        //QuickSort TEST unsorted and sorted
        System.out.println("Sorteando con QuickSort");
        SortedArray = sorter.QuickSort(arrayToSort);
        txtManager.writeResult("Sorted.txt", SortedArray);
        sorter.QuickSort(SortedArray);

        //RadixSort TEST unsorted and sorted
        System.out.println("Sorteando con RadixSort");
        SortedArray = sorter.radixSort(arrayToSort);
        txtManager.writeResult("Sorted.txt", SortedArray);
        sorter.radixSort(SortedArray);

        //SeleccionSort TEST unsorted and sorted
        System.out.println("Sorteando con SeleccionSort");
        SortedArray = sorter.SeleccionSort(arrayToSort);
        txtManager.writeResult("Sorted.txt", SortedArray);
        sorter.SeleccionSort(SortedArray);

        System.out.println("Sorteo Terminado");

    }
}