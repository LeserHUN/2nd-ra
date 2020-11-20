import java.util.Scanner;

public class HW2 {

    public static void main(String[] args) {
        System.out.println("2.Feladat");
        System.out.println("Írja be a visszafordítandó szöveget!");
        Scanner scanner = new Scanner(System.in);
        String alap = scanner.nextLine();

        String szav = "";
        for (int i = alap.length()-1; i >= 0; i--){
            char aszav = alap.charAt(i);
            szav = szav + aszav;
        }
    System.out.println(szav);
    }
}
