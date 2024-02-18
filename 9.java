import java.io.*;
import java.util.Scanner;

class Knapsack {

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        // Display the matrix
        System.out.println("Dynamic Programming Matrix:");
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                System.out.print(K[i][w] + " ");
            }
            System.out.println();
        }

        return K[n][W];
    }

    // Driver code
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int profit[] = new int[n];
        int weight[] = new int[n];

        System.out.println("Enter the values of items:");
        for (int i = 0; i < n; i++) {
            profit[i] = scanner.nextInt();
        }

        System.out.println("Enter the weights of items:");
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }

        System.out.print("Enter the knapsack capacity: ");
        int W = scanner.nextInt();

        System.out.println("Maximum value in Knapsack: " + knapSack(W, weight, profit, n));
    }
}
