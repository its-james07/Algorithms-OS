import java.util.Scanner;
public class FirstCFS{
static int findSeekTime(int request, int currentPosition, int[] positions) {
    int seekTime = 0;
    System.out.print("Head movement order: " + currentPosition); 
    for (int i = 0; i < request; i++) {
    seekTime += Math.abs(currentPosition - positions[i]);
    currentPosition = positions[i];
    System.out.print(" -> " + currentPosition);
    }
    System.out.println(); 
    return seekTime;
}
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] positions = {82, 170, 43, 140, 24, 16, 190};
        System.out.println("Enter Current Position of Track");
        int currentPosition = sc.nextInt();
        int request = positions.length;
        int result = findSeekTime(request, currentPosition, positions);
        System.out.println("Seek Time : "+result);
        sc.close();
    }    
}