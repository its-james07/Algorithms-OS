import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class LookAlgo {
static int findSeekTime(int request, int currentPosition, int[] positions, int direction) {
int seekTime = 0;
PriorityQueue<Integer> leftTracks = new PriorityQueue<>(Collections.reverseOrder());
PriorityQueue<Integer> rightTracks = new PriorityQueue<>();

for (int r : positions) {
    if (r < currentPosition) {
                leftTracks.add(r);
    } else {
                rightTracks.add(r);
    }
}
int rs = rightTracks.size();
int ls = leftTracks.size();
if (rs == 0 && ls == 0) {
    System.out.println("No requests to process.");
    return 0;
}
if (direction == 1) { 
    if (rightTracks.isEmpty()) {
        while (!leftTracks.isEmpty()) {
        int next = leftTracks.poll();
        seekTime += Math.abs(currentPosition - next);
        currentPosition = next;
    }
    } else {
        while (!rightTracks.isEmpty()) {
        int next = rightTracks.poll();
        seekTime += Math.abs(currentPosition - next);
        currentPosition = next;
    }
    while (!leftTracks.isEmpty()) {
        int next = leftTracks.poll();
        seekTime += Math.abs(currentPosition - next);
        currentPosition = next;
    }}   
    } else { 
    if (leftTracks.isEmpty()) {
        while (!rightTracks.isEmpty()) {
        int next = rightTracks.poll();
        seekTime += Math.abs(currentPosition - next);
        currentPosition = next;
    }
    } else {
        while (!leftTracks.isEmpty()) {
        int next = leftTracks.poll();
        seekTime += Math.abs(currentPosition - next);
        currentPosition = next;
    }
    while (!rightTracks.isEmpty()) {
        int next = rightTracks.poll();
        seekTime += Math.abs(currentPosition - next);
        currentPosition = next;
    }}}
    return seekTime;}
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
        int currentPosition = sc.nextInt();
        System.out.println("Enter Initial Direction (0 for left, 1 for right):");
        int direction = sc.nextInt();
        int result = findSeekTime(request, currentPosition, positions, direction);
        System.out.println("Total Seek Time: " + result);
        sc.close();
    }
}
