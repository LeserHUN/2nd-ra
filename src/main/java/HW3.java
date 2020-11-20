import java.util.Scanner;

public class HW3 {

    public static void main(String[] args) {
        System.out.println("3.Feldatad:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Név:");
        String nev = scanner.nextLine();


        System.out.println("Nem: (Férfi/Nő)");
        String nem = scanner.nextLine();
        switch (nem) {
            case "Férfi":
                System.out.println("");
                break;

            case "Nő":
                System.out.println("");
                break;

            default:
                System.out.println("Ön esetleg egyéb nemű?");
        }


        System.out.println("Kor:");
        Integer kor = scanner.nextInt() ;

        if (kor<20){
            if (nem.equals("Nő")){
                System.out.println("Hi, Miss " + nev);
            }
            if (nem.equals("Férfi")){
                System.out.println("Hello, "+ nev);
            }
        }
        if (kor>=20){
            if (nem.equals("Nő")){
                System.out.println("Good morning, Mrs "+ nev);
            }
            if (nem.equals("Férfi")){
                System.out.println("Good morning, Mr "+ nev);
            }
        }
    }
}
