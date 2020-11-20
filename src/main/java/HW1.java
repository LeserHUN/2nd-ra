import java.util.Scanner;

public class HW1 {

    public static void main(String[]args) {
        System.out.println("1. Feladat");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérjük Írja be a mondatot!");
        String mondat = scanner.nextLine();

        String szoveg = mondat;
        String[] darabok = szoveg.split(" ");

        for (int i = 0 ; i < darabok.length; i++ ){
            // System.out.println(darabok[i]);
        }

    }
}
