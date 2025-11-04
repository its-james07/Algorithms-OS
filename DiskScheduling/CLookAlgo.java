import java.util.Arrays;
import java.util.Scanner;
public class CLookAlgo {
static int findSeekTime(int headPosition, int[] positions, int direction) {
int seekTime = 0;
int currentPosition = headPosition;
Arrays.sort(positions);
System.out.print("Head movement order: " + currentPosition);
if (direction == 1) {
    for (int i = 0; i < positions.length; i++) {
        if (positions[i] >= currentPosition) {
            seekTime += Math.abs(currentPosition - positions[i]);
            currentPosition = positions[i];
            System.out.print(" -> " + currentPosition);
        }}
    if (positions[0] < currentPosition) {
        seekTime += Math.abs(currentPosition - positions[0]);
        currentPosition = positions[0];
        System.out.print(" -> " + currentPosition);
    }
    for (int i = 1; i < positions.length; i++) {
    if (positions[i] > currentPosition && positions[i] <= headPosition) {
        seekTime += Math.abs(currentPosition - positions[i]);
        currentPosition = positions[i];
        System.out.print(" -> " + currentPosition);
    }}
    } else {
    for (int i = positions.length - 1; i >= 0; i--) {
        if (positions[i] < currentPosition) {
            seekTime += Math.abs(currentPosition - positions[i]);
            currentPosition = positions[i];
            System.out.print(" -> " + currentPosition);
            }
        }
        if (positions[positions.length - 1] > currentPosition) {
            seekTime += Math.abs(currentPosition - positions[positions.length - 1]);
            currentPosition = positions[positions.length - 1];
            System.out.print(" -> " + currentPosition);
        }
        for (int i = positions.length - 2; i >= 0; i--) {
            if (positions[i] > headPosition) {
            seekTime += Math.abs(currentPosition - positions[i]);
            currentPosition = positions[i];
            System.out.print(" -> " + currentPosition);
        }}}
    System.out.println();
    return seekTime;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Requests:");
        int request = sc.nextInt();
        int[] positions = new int[request];
        System.out.println("Enter Requested Track Positions:");
        for (int i = 0; i < request; i++) {
            positions[i] = sc.nextInt();
        }
        System.out.println("Enter Current Position of Track:");
        int headPosition = sc.nextInt();
        System.out.println("Enter Initial Direction (0 for left, 1 for right):");
        int direction = sc.nextInt();
        int result = findSeekTime(headPosition, positions, direction);
        System.out.println("Total Seek Time (C-LOOK): " + result);
        sc.close();
    }
}
