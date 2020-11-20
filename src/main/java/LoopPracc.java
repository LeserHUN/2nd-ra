import java.util.Scanner;

public class LoopPracc {

    public static void main(String[] args) {
        System.out.println("3.Feldatad:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Név:");
        String nev = scanner.nextLine();


        System.out.println("Nem: (Férfi/Nő)");
        String nem = scanner.nextLine();
        switch (nem) {
            case "Férfi":
                System.out.println("f");
                break;

            case "Nő":
                System.out.println("n");
                break;

            default:
                System.out.println("Ön esetleg egyéb nemű?");
        }


        System.out.println("Kor:");
        Integer kor = scanner.nextInt();

    }

}
