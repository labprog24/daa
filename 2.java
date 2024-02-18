import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = generateRandomArray(n);

        System.out.println("Original Array:");
        printArray(arr);

        long startTimeNano = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long endTimeNano = System.nanoTime();

        System.out.println("\nSorted Array:");
        printArray(arr);

        long durationNano = endTimeNano - startTimeNano;
        double durationMilli = durationNano / 1_000_000.0; 

        System.out.println("\nTime taken for Quick Sort:");
        System.out.println("Nanoseconds: " + durationNano);
        System.out.println("Milliseconds: " + durationMilli);

        scanner.close();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100); 
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
