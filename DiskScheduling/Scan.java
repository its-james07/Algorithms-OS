import java.util.Arrays;
import java.util.Scanner;
public class Scan{
    static int findSeekTime(int request, int currentPosition, int[] positions, int diskSize, int direction) {
        int seekTime = 0;
        int[] leftTracks = new int[request + 1];
        int[] rightTracks = new int[request + 1];
        int leftCount = 0, rightCount = 0;

        for (int r : positions) {
            if (r < currentPosition) {
                leftTracks[leftCount++] = r;
            } else {
                rightTracks[rightCount++] = r;
            }
        }
        if (direction == 0) {
            leftTracks[leftCount++] = 0; } 
            else {
            rightTracks[rightCount++] = diskSize - 1;
        }
        Arrays.sort(leftTracks, 0, leftCount);
        Arrays.sort(rightTracks, 0, rightCount);
        if (direction == 1) {
            for (int i = 0; i < rightCount; i++) {
                seekTime += Math.abs(currentPosition - rightTracks[i]);
                currentPosition = rightTracks[i];
            }
            for (int i = leftCount - 1; i >= 0; i--) {
                seekTime += Math.abs(currentPosition - leftTracks[i]);
                 currentPosition = leftTracks[i]; }
        } else {
            for (int i = leftCount - 1; i >= 0; i--) {
                seekTime += Math.abs(currentPosition - leftTracks[i]);
                currentPosition = leftTracks[i];
            }
            for (int i = 0; i < rightCount; i++) {
                seekTime += Math.abs(currentPosition - rightTracks[i]);
                currentPosition = rightTracks[i];
            }
        } return seekTime;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Requests");
        int request = sc.nextInt();
        int[] positions = new int[request];
        System.out.println("Enter Requested Track Positions");
        for (int i = 0; i < request; i++) {
            positions[i] = sc.nextInt(); }
        System.out.println("Enter Current Position of Track");
        int currentPosition = sc.nextInt();
        System.out.println("Enter Disk Size");
        int diskSize = sc.nextInt();
        System.out.println("Enter Initial Direction (0 for left, 1 for right)");
        int direction = sc.nextInt();
        int result = findSeekTime(request, currentPosition, positions, diskSize, direction);
        System.out.println("Total Seek Time: " + result);
        sc.close();
    }
}
