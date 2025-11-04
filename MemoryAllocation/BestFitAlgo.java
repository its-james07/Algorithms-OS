import java.util.Scanner;
public class BestFitAlgo { 
static void bestFit(int[] blockSize, int m, int[] processSize, int n) {
int[] allocation = new int[n];
    for (int i = 0; i < n; i++) {
        allocation[i] = -1;
    }
        
    for (int i = 0; i < n; i++) {
        int bestIdx = -1;
        for (int j = 0; j < m; j++) {
        if (blockSize[j] >= processSize[i]) {
        if (bestIdx == -1 || blockSize[j] < blockSize[bestIdx]) {
            bestIdx = j;
        }}}
    if (bestIdx != -1) {
        allocation[i] = bestIdx;
        blockSize[bestIdx] -= processSize[i];
}} 
System.out.println("\nBest Fit Allocation:");
    System.out.println("Process No.\tProcess Size\tBlock No.");
    for (int i = 0; i < n; i++) {
        System.out.print(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
        if (allocation[i] != -1) {
            System.out.println(allocation[i] + 1);
    } else {
        System.out.println("Not Allocated");
    }}} 
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Best Fit Memory Allocation");
        System.out.print("Enter number of memory blocks: ");
        int m = sc.nextInt();
        int[] blockSize = new int[m];
        System.out.println("Enter sizes of memory blocks:");
        for (int i = 0; i < m; i++) {
            System.out.print("Block " + (i + 1) + " size: ");
            blockSize[i] = sc.nextInt();
        }
        System.out.print("\nEnter number of processes: ");
        int n = sc.nextInt();
        int[] processSize = new int[n];
        
        System.out.println("Enter sizes of processes:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i + 1) + " size: ");
            processSize[i] = sc.nextInt();
        }
        bestFit(blockSize, m, processSize, n);
        sc.close();
    }
}