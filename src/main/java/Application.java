import java.util.*;

public class Application {
    public static void main(String[] args) {
        int[] tomb = new int[3];
        tomb[0] = 1;
        tomb[1] = 2;
        tomb[2] = 3;
        System.out.println(tomb[2]);
        List<Integer> lista = new ArrayList<>();

        lista.add(11);
        lista.add(22);
        lista.add(33);
        lista.add(44);
        lista.add(55);
        lista.add(66);
        System.out.println(lista);

        List<String> felsorolas = new ArrayList<>();

        felsorolas.add("Repa") ;
        felsorolas.add("Retek") ;
        felsorolas.add("Mogyoro") ;
        System.out.println(felsorolas);

        Integer[][] ketDTomb = new Integer[3][3] ;
        ketDTomb[0][0] = 1;
        ketDTomb[0][1] = 2;
        ketDTomb[0][2] = 3;

        System.out.println(Arrays.toString(ketDTomb[0]));

        Map<Integer, String> map = new HashMap<>();
        map.put(12, "Szép vok, te nem!");
        System.out.println(map.get(12));
    }
}
