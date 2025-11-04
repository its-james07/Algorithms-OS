import java.util.Scanner;
import java.util.ArrayList;
public class OptimalPage {
static void replacePageOptimal(int[] referenceString, int frameCount){
ArrayList<Integer> frameBlock = new ArrayList<>();
int pageHits = 0, pageFaults = 0;
int n = referenceString.length;
System.out.println("\nOptimal Page Replacement");
for (int i = 0; i < n; i++) {
        int page = referenceString[i];
        System.out.print("Page " + page + " -> ");
        if (frameBlock.contains(page)) {
            pageHits++;
            System.out.println("HIT  | Frames: " + frameBlock);
        } else {
        pageFaults++;
        if (frameBlock.size() < frameCount) {
            frameBlock.add(page);
        } else {
        int farthest = -1, idxToReplace = -1;
        for (int j = 0; j < frameBlock.size(); j++) {
            int futureUse = Integer.MAX_VALUE;
            for (int k = i + 1; k < n; k++) {
                if (frameBlock.get(j) == referenceString[k]) {
                    futureUse = k;
                    break;
                }
            }
            if (futureUse > farthest) {
                farthest = futureUse;
                idxToReplace = j;
            }
        }
    frameBlock.set(idxToReplace, page);}
    System.out.println("FAULT | Frames: " + frameBlock);
}}
    System.out.println("\nTotal Hits: " + pageHits);
    System.out.println("Total Faults: " + pageFaults);
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
    replacePageOptimal(referenceString, frameCount);
    sc.close();
    }
}
