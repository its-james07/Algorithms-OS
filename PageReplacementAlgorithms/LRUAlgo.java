import java.util.Scanner;
import java.util.ArrayList;
public class LRUAlgo {
static void replacePageLRU(int[] referenceString, int frameCount) {
    ArrayList<Integer> frameBlock = new ArrayList<>();
    int pageHits = 0, pageFaults = 0;
    System.out.println("\nLRU Page Replacement\n");
    for (int page : referenceString) {
        System.out.print("Page " + page + " -> ");
        if (frameBlock.contains(page)) {
            pageHits++;
            frameBlock.remove((Integer) page); 
            frameBlock.add(page);
            System.out.println("HIT   | Frames: " + frameBlock);
        } else {
            // Page fault
            pageFaults++;
            if (frameBlock.size() == frameCount)
                frameBlock.remove(0); 
            frameBlock.add(page); 
            System.out.println("FAULT | Frames: " + frameBlock);
        }
    }
    System.out.println("Total Page Hits   : " + pageHits);
    System.out.println("Total Page Faults : " + pageFaults);
    System.out.printf("Hit Ratio   : %.2f%%\n", (pageHits * 100.0 / referenceString.length));
    System.out.printf("Fault Ratio : %.2f%%\n", (pageFaults * 100.0 / referenceString.length));
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of pages: ");
    int n = sc.nextInt();
    int[] referenceString = new int[n];
    System.out.println("Enter reference string:");
    for (int i = 0; i < n; i++)
        referenceString[i] = sc.nextInt();
    System.out.print("Enter number of frames: ");
    int frameCount = sc.nextInt();
    replacePageLRU(referenceString, frameCount);
    sc.close();
    }
}
