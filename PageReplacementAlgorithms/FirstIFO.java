import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class FirstIFO {
static void replacePageFIFO(int[] referenceString, int frameCount) {
    int pageFaults = 0, pageHits = 0;
    Queue<Integer> frameBlock = new LinkedList<>();
    for (int page : referenceString) {
        System.out.print("Page " + page + " -> ");
        if (frameBlock.contains(page)) {
            pageHits++;
            System.out.print("HIT\t");
        } else {
            pageFaults++;
        if (frameBlock.size() == frameCount) {
            int removed = frameBlock.poll();
            System.out.print("FAULT (Removed " + removed + ")\t");
        } else {
            System.out.print("FAULT\t\t");
        }
        frameBlock.add(page); }
        System.out.println("Frames: " + frameBlock); }
        System.out.println("Total Page Hits   : " + pageHits);
        System.out.println("Total Page Faults : " + pageFaults);
        System.out.printf("Hit Ratio   : %.2f%%\n", (pageHits * 100.0 / referenceString.length));
        System.out.printf("Fault Ratio : %.2f%%\n", (pageFaults * 100.0 / referenceString.length));
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of pages in the reference string: ");
    int n = sc.nextInt();
    int[] referenceString = new int[n];
    System.out.println("Enter the reference string (page numbers): ");
    for (int i = 0; i < n; i++) {
        referenceString[i] = sc.nextInt();}
    System.out.print("Enter the number of frames: ");
    int frameCount = sc.nextInt();
    System.out.println("Page Replacement (FIFO)");
    replacePageFIFO(referenceString, frameCount);
    sc.close();
    }
}
