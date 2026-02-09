import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

public class SorterTest {
    
    private final Sorter<Integer> sorter = new Sorter<>();
    private final Random random = new Random();
    
    @Test
    void testGnomeSort() {
        // prueba con Array aleatorio
        Integer[] arr1 = {5, 3, 8, 1, 2, 7, 4, 6};
        Integer[] expected1 = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] result1 = sorter.GnomeSort(arr1.clone());
        assertArrayEquals(expected1, result1, "No se ordenó correctamente");
        
        // prueba con Array ya ordenado
        Integer[] arr2 = {1, 2, 3, 4, 5};
        Integer[] result2 = sorter.GnomeSort(arr2.clone());
        assertArrayEquals(arr2, result2, "no se mantuvo el array ya ordenado");
        
        // con Array ordenado inversamente
        Integer[] arr3 = {5, 4, 3, 2, 1};
        Integer[] expected3 = {1, 2, 3, 4, 5};
        Integer[] result3 = sorter.GnomeSort(arr3.clone());
        assertArrayEquals(expected3, result3, "no se ordenó el array inverso");
    }
    
    @Test
    void testMergeSort() {
        // Prueba con Array aleatorio
        Integer[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        Integer[] expected1 = {3, 9, 10, 27, 38, 43, 82};
        Integer[] result1 = sorter.MergeSort(arr1.clone());
        assertArrayEquals(expected1, result1, "MergeSort no ordenó correctamente");
        
        // Prueba de Array con elementos repetidos
        Integer[] arr2 = {5, 2, 8, 2, 5, 1, 8};
        Integer[] expected2 = {1, 2, 2, 5, 5, 8, 8};
        Integer[] result2 = sorter.MergeSort(arr2.clone());
        assertArrayEquals(expected2, result2, "MergeSort no funcionó correctamente");
        
        // Prueba de Array grande aleatorio
        Integer[] arr3 = generateRandomArray(100);
        Integer[] sorted3 = arr3.clone();
        Arrays.sort(sorted3);
        Integer[] result3 = sorter.MergeSort(arr3.clone());
        assertArrayEquals(sorted3, result3, "MergeSort no funcionó");
    }
    
    @Test
    void testQuickSort() {
        // Prueba con Array aleatorio
        Integer[] arr1 = {10, 7, 8, 9, 1, 5};
        Integer[] expected1 = {1, 5, 7, 8, 9, 10};
        Integer[] result1 = sorter.QuickSort(arr1.clone());
        assertArrayEquals(expected1, result1, "QuickSort no ordenó correctamente");
        
        // Prueba de Array con valores iguales al pivote
        Integer[] arr2 = {4, 2, 4, 1, 4, 3};
        Integer[] expected2 = {1, 2, 3, 4, 4, 4};
        Integer[] result2 = sorter.QuickSort(arr2.clone());
        assertArrayEquals(expected2, result2, "QuickSort funcionó correctamente");
        
        // Prueba con Array ya ordenado
        Integer[] arr3 = {1, 2, 3, 4, 5, 6};
        Integer[] result3 = sorter.QuickSort(arr3.clone());
        assertArrayEquals(arr3, result3, "QuickSort no mantuvo el array ya ordenado");
    }
    
    @Test
    void testSeleccionSort() {
        // Prueba con Array aleatorio
        Integer[] arr1 = {64, 25, 12, 22, 11};
        Integer[] expected1 = {11, 12, 22, 25, 64};
        Integer[] result1 = sorter.SeleccionSort(arr1.clone());
        assertArrayEquals(expected1, result1, "SeleccionSort no ordenó correctamente");
        
        // Prueba de Array con números negativos
        Integer[] arr2 = {-5, 2, -8, 0, 1, -3};
        Integer[] expected2 = {-8, -5, -3, 0, 1, 2};
        Integer[] result2 = sorter.SeleccionSort(arr2.clone());
        assertArrayEquals(expected2, result2, "SeleccionSort no funcionó");
        
        // Prueba de Array con un solo elemento
        Integer[] arr3 = {42};
        Integer[] result3 = sorter.SeleccionSort(arr3.clone());
        assertArrayEquals(arr3, result3, "SeleccionSort no funcionó");
    }
    
    @Test
    void testRadixSort() {
        // Prueba con Array de enteros positivos
        Integer[] arr1 = {170, 45, 75, 90, 802, 24, 2, 66};
        Integer[] expected1 = {2, 24, 45, 66, 75, 90, 170, 802};
        Integer[] result1 = sorter.radixSort(arr1.clone());
        assertArrayEquals(expected1, result1, "RadixSort no funcionó correctamente");
        
        // Prueba con Array con números negativos
        Integer[] arr2 = {-5, 10, -15, 20, -25, 0, 5};
        Integer[] expected2 = {-25, -15, -5, 0, 5, 10, 20};
        Integer[] result2 = sorter.radixSort(arr2.clone());
        assertArrayEquals(expected2, result2, "RadixSort no funcionó correctamente");
        
        // Prueba de Array con números de diferente cantidad de dígitos
        Integer[] arr3 = {9, 87, 123, 5, 4321, 65, 987, 1};
        Integer[] expected3 = {1, 5, 9, 65, 87, 123, 987, 4321};
        Integer[] result3 = sorter.radixSort(arr3.clone());
        assertArrayEquals(expected3, result3, "RadixSort no funcionó correctamente");
    }
    
    @Test
    void testTodosLosSortersConMismoArray() {
        Integer[] original = {23, 1, 45, 67, 2, 89, 34, 12, 78, 56};
        Integer[] expected = original.clone();
        Arrays.sort(expected);
        
        assertArrayEquals(expected, sorter.GnomeSort(original.clone()), 
            "GnomeSort no funcionó");
        
        assertArrayEquals(expected, sorter.MergeSort(original.clone()), 
            "MergeSort no funcionó");
        
        assertArrayEquals(expected, sorter.QuickSort(original.clone()), 
            "QuickSort no funcionó");
        
        assertArrayEquals(expected, sorter.SeleccionSort(original.clone()), 
            "SeleccionSort no funcionó");
        
        assertArrayEquals(expected, sorter.radixSort(original.clone()), 
            "RadixSort no funcionó");
    }
    
    @Test
    void testArrayVacio() {
        Integer[] empty = {};
        
        assertArrayEquals(empty, sorter.GnomeSort(empty.clone()), 
            "GnomeSort no funcionó");
        
        assertArrayEquals(empty, sorter.MergeSort(empty.clone()), 
            "MergeSort no funcionó");
        
        assertArrayEquals(empty, sorter.QuickSort(empty.clone()), 
            "QuickSort no funcionó");
        
        assertArrayEquals(empty, sorter.SeleccionSort(empty.clone()), 
            "SeleccionSort no funcionó");
        
        assertArrayEquals(empty, sorter.radixSort(empty.clone()), 
            "RadixSort no funcionó");
    }
    
    @Test
    void testArrayUnElemento() {
        Integer[] single = {42};
        
        // Todos los algoritmos deben mantener array de un elemento
        assertArrayEquals(single, sorter.GnomeSort(single.clone()), 
            "GnomeSort no funcionó");
        
        assertArrayEquals(single, sorter.MergeSort(single.clone()), 
            "MergeSort no funcionó");
        
        assertArrayEquals(single, sorter.QuickSort(single.clone()), 
            "QuickSort no funcionó");
        
        assertArrayEquals(single, sorter.SeleccionSort(single.clone()), 
            "SeleccionSort no funcionó");
        
        assertArrayEquals(single, sorter.radixSort(single.clone()), 
            "RadixSort no funcionó");
    }
    
    // generar arrays aleatorios
    private Integer[] generateRandomArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000); // Números entre 0 y 999
        }
        return arr;
    }
}