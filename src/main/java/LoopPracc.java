import java.util.Scanner;

public class LoopPracc {

    public static void main(String[] args) {
        System.out.println("3.Feldatad:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Név:");
        String nev = scanner.nextLine();

        System.out.println("Nem: (Férfi/Nő)");
        String nem = scanner.nextLine();
        if ("Férfi".equals(nem)) {
            System.out.println("Férfi");
        } else if ("Nő".equals(nem));{
            System.out.println("Nő")";
        }


            System.out.println("Kor:");
        Integer kor = scanner.nextInt();

    }

}
