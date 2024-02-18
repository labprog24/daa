import java.util.Scanner;
import java.util.Random;

class MergeSortExp {
    public static void mergeSort(int[] a, int low, int high) {
        int n = high - low;
        if (n <= 1)
            return;
        int mid = low + n / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid, high);
        int[] temp = new int[n];
        int i = low, j = mid;
        for (int k = 0; k < n; k++) {
            if (i == mid)
                temp[k] = a[j++];
            else if (j == high)
                temp[k] = a[i++];
            else if (a[j] < a[i])
                temp[k] = a[j++];
            else
                temp[k] = a[i++];
        }
        for (int k = 0; k < n; k++)
            a[low++] = temp[k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        Random r = new Random();
        System.out.println("Merge Sort\n Enter the number of elements:");
        int m = sc.nextInt();
        System.out.println("Random numbers generated are as follows:");
        int[] a = new int[m];
        for (i = 0; i < m; i++) {
            a[i] = r.nextInt() % 100;
            System.out.println(a[i] + " ");
        }
        System.out.println(" ");
        long startTime = System.nanoTime();
        mergeSort(a, 0, m);
        long endTime = System.nanoTime();
        double totaldur = (endTime - startTime);
        System.out.println("Elements after sorting are:");
        for (i = 0; i < m; i++)
            System.out.println(a[i] + " ");
        System.out.println(" ");
        System.out.println("\nTotal time taken to sort is:" + totaldur + "NanoSeconds");
        double milliseconds = (totaldur / 1000000);
        System.out.println("\nTotal time taken to sort is:" + milliseconds + "MiliSeconds");
        sc.close();
    }
}
