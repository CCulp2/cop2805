package cop2805;
import java.util.*;

public class CCulpHomework2 {


    public static void Output(ArrayList l) {
        for (Object o : l){
            System.out.print(o + " ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* Create initial list with initials. I've chosen to use the original
            spelling of my last name "Kulp" instead of "Culp" to avoid having
            CDC be the initials and making it hard to tell that the list has been
            reversed.
         */
        ArrayList<String> firstList = new ArrayList<>();
        firstList.add("C");
        firstList.add("D");
        firstList.add("K");

        // Output the list.
        System.out.println("Initial List:");
        Output(firstList);

        // Reverse the list then output.
        Collections.reverse(firstList);
        System.out.println("Reversed List:");
        Output(firstList);

        // Shallow copy of the original list.
        ArrayList<String> copiedList = (ArrayList<String>) firstList.clone();
        System.out.println("Copied List:");
        Output(copiedList);

        // Replace every initial in original list with R.
        for (int i = 0; i < firstList.size(); ++i) {
            firstList.set(i, "R");
        }
        System.out.println("R filled List:");
        Output(firstList);






    }


}
