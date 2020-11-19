import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForApplication {
    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4};

        System.out.println("Array by index");

        System.out.println(intArray[0]);
        System.out.println(intArray[1]);
        System.out.println(intArray[2]);
        System.out.println(intArray[3]);
        System.out.println();
        System.out.println("Array with for");


        for (int i = 0; i < intArray.length; i++) {
            System.out.println(i + "-edik elem a tömbben: " + intArray[i]);
        }
        System.out.println();
        System.out.println("Array enhanced with for");

        for (int elem : intArray) {
            System.out.println("Elem: " + elem);
        }
//==========================
        List<String> stringList = new ArrayList<>();
        stringList.add("Egy");
        stringList.add("Kettő");
        stringList.add("Három");
        stringList.add("Négy");
        System.out.println();
        System.out.println("List with for - every 2nd item");
        for (int i = 0; i < stringList.size(); i += 2) {
            System.out.println(i + "-edik elem a listában: " + stringList.get(i));
        }
            System.out.println();
            System.out.println("List with enhanced for");
        for (String elem : stringList) {
            System.out.println("Elem: " + elem);
        }

        Map<Integer, String> intStringMap = new HashMap<>();
        intStringMap.put(1, "Egy");
        intStringMap.put(2, "Kettő");
        intStringMap.put(3, "Három");
        intStringMap.put(4, "Négy");

        System.out.println();
        System.out.println("Map with enchanged for");

        for (Map.Entry<Integer, String> entry : intStringMap.entrySet()) {
            System.out.println("Kulcs: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
