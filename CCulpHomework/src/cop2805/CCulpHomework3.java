package cop2805;

public class CCulpHomework3 {
    public static <E extends Comparable<E>> E max (E [] list) {
        E currentMax = list[0];
        for (int i = 1; i < list.length; ++i) {
            if (list[i].compareTo(currentMax) > 0) {
                currentMax = list[i];
            }
        }

        return currentMax;
    }

    public static void main(String[] args) {
        String[] colors = {"Red","Green","Blue"};
        Integer[] numbers = {1, 2, 3};
        Double[] circleRadius = {3.0, 5.9, 2.9};

        System.out.print("Max of Colours: ");
        System.out.println(max(colors));
        System.out.print("Max of Numbers: ");
        System.out.println(max(numbers));
        System.out.print("Max of Circle Radius: ");
        System.out.println(max(circleRadius));
    }
}
