import java.util.Scanner;
import java.util.ArrayList;
public class MRUAlgo {
static void replacePageMRU(int[] referenceString, int frameCount){
    ArrayList<Integer> frames = new ArrayList<>();
    int pageHits = 0, pageFaults = 0;
    System.out.println("\nMRU Page Replacement");
    for (int page : referenceString) {
    System.out.print("Page " + page + " -> ");
    if (frames.contains(page)) {
    pageHits++;
    frames.remove((Integer) page);
    frames.add(page); 
    System.out.println("HIT  | Frames: " + frames);
    } else {
    pageFaults++;
    if (frames.size() == frameCount)
    frames.remove(frames.size() - 1);
    frames.add(page);
    System.out.println("FAULT | Frames: " + frames);
}}
    System.out.println("\nTotal Hits: " + pageHits);
    System.out.println("Total Faults: " + pageFaults);
    System.out.printf("Hit Ratio   : %.2f%%\n", (pageHits * 100.0 / referenceString.length));
    System.out.printf("Fault Ratio : %.2f%%\n", (pageFaults * 100.0 / referenceString.length));
}
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();
        int[] referenceString = new int[n];
        System.out.println("Enter reference string:");
        for (int i = 0; i < n; i++) referenceString[i] = sc.nextInt();

        System.out.print("Enter number of frames: ");
        int frameCount = sc.nextInt();
    replacePageMRU(referenceString, frameCount);
        }
}