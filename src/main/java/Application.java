import java.util.*;

public class Application {
    public static void main(String[] args) {
        int[] tomb = new int[3];
        tomb[0] = 1;
        tomb[1] = 2;
        tomb[2] = 3;
        System.out.println(tomb[2]);
        List<Integer> lista = new ArrayList<>(2);

        lista.add(3);
        lista.add(4);
        lista.add(77);
        lista.add(44);
        lista.add(55);
        lista.add(66);
        System.out.println(lista.get(1)); System.out.println(lista.get(5));



        int[][] ketDTomb = new int [3][3];
        ketDTomb[0][0] = 1;
        ketDTomb[0][1] = 2;
        ketDTomb[1][0] = 3;
        ketDTomb[1][1] = 4;
        ketDTomb[2][1] = 5;
        ketDTomb[2][2] = 6;
        ketDTomb[1][2] = 7;
        System.out.println(Arrays.toString(ketDTomb[1]));

        Map<String, Integer> map = new HashMap<>();
        map.put("kulcs1", 12);
        map.put("kulcs2", 24);
        System.out.println(map.get("kulcs1"));
    }
}
