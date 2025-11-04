import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class ShortSTF {
    static int findSeekTime(int request, int[] positions, int currentPosition) {
        int seekTime = 0, completed = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int r : positions) {
            if (r < currentPosition) {
                maxHeap.add(r);
            } else {
                minHeap.add(r);
            }
        }
        System.out.print("Head movement order: " + currentPosition);
        while (completed < request) {
            int next;
            Integer topofMax = maxHeap.peek();
            Integer topofMin = minHeap.peek();
            if (topofMax == null) {
                next = minHeap.poll();
            } else if (topofMin == null) {
                next = maxHeap.poll();
            } else {
                if (Math.abs(currentPosition - topofMax) < Math.abs(currentPosition - topofMin)) {
                next = maxHeap.poll();}
                else { next = minHeap.poll();}
            }
            seekTime += Math.abs(currentPosition - next);
            currentPosition = next;
            completed++;
            System.out.print(" -> " + currentPosition);}
        System.out.println();
        return seekTime; }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] positions = { 82, 170, 43, 140, 24, 16, 190 };
        System.out.println("Enter Current Position of Track:");
        int currentPosition = sc.nextInt();
        int request = positions.length;
        int result = findSeekTime(request, positions, currentPosition);
        System.out.println("Total Seek Time (SSTF): " + result);
        sc.close(); }}
