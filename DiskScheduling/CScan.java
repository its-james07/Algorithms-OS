import java.util.Arrays;
import java.util.Scanner;
public class CScan {
    static int findSeekTime(int request, int currentPosition, int[] positions, int diskSize, int direction) {
        int seekTime = 0;
        int[] leftTracks = new int[request];
        int[] rightTracks = new int[request];
        int leftCount = 0, rightCount = 0;
        for (int r : positions) {
            if (r < currentPosition) leftTracks[leftCount++] = r;
            else rightTracks[rightCount++] = r;
        }
        Arrays.sort(leftTracks, 0, leftCount);
        Arrays.sort(rightTracks, 0, rightCount);

        if (direction == 1) {
            for (int i = 0; i < rightCount; i++) {
                seekTime += Math.abs(currentPosition - rightTracks[i]);
                currentPosition = rightTracks[i];
            }
            if (leftCount > 0) {
                seekTime += Math.abs(currentPosition - (diskSize - 1));
                currentPosition = 0;
                seekTime += diskSize - 1;
                for (int i = 0; i < leftCount; i++) {
                    seekTime += Math.abs(currentPosition - leftTracks[i]);
                    currentPosition = leftTracks[i]; }
            }
        } else {
            for (int i = leftCount - 1; i >= 0; i--) {
                seekTime += Math.abs(currentPosition - leftTracks[i]);
                currentPosition = leftTracks[i];
            }
            if (rightCount > 0) {
                seekTime += Math.abs(currentPosition - 0);
                currentPosition = diskSize - 1;
                seekTime += diskSize - 1;
                for (int i = rightCount - 1; i >= 0; i--) {
                    seekTime += Math.abs(currentPosition - rightTracks[i]);
                    currentPosition = rightTracks[i]; }}}
        return seekTime;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int request = sc.nextInt();
        int[] positions = new int[request];
        for (int i = 0; i < request; i++) positions[i] = sc.nextInt();
        int currentPosition = sc.nextInt();
        int diskSize = sc.nextInt();
        int direction = sc.nextInt();
        System.out.println(findSeekTime(request, currentPosition, positions, diskSize, direction));
        sc.close();
    }
}
