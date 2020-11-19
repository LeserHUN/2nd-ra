import java.util.Scanner;

public class Application {
    private static boolean igaz() {
        System.out.println("Az igaz meg lett hívva");
        return true;
    }

    private static boolean hamis() {
        System.out.println("A hamis meg lett hívva");
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Első szám:");
        Integer szam1 = scanner.nextInt();

        System.out.println("Operandus:");
        String operand = new Scanner(System.in).nextLine();

        System.out.println("Masodik szam");
        Integer szam2 = scanner.nextInt();

        System.out.println("Ezt a műveletet fogjuk elvégezni: " + szam1 + " " + operand + " " + szam2);

        Double eredmeny = null;
        if ("+".equals(operand)) {
            eredmeny = (double) szam1 + szam2;
        } else if ("-" == operand) {
            eredmeny = (double) szam1 - szam2;
        } else if ("*".equals(operand)) {
            eredmeny = (double) szam1 * szam2;
        } else {
            System.out.println("Ismeretlen operandus: " + operand);

        }
        System.out.println("Eredmeny: " + eredmeny);
        if (szam1 <= 0) {
            System.out.println("Ez egy kis szám");
        }
        if (szam1 < 0 && szam2 < 0) {
            System.out.println("Mindkét szám kisebb mint 0");
        }
        if (szam1 < 0 || szam2 < 0) {
            System.out.println("Az egyik szám kisebb mint 0");
        }
        System.out.println("Teszt &&");

        if (hamis() && igaz()) {
            System.out.println("Ennek nem szabad kiíródnia");
        }
        System.out.println("Teszt &");
        if (hamis() & igaz()) {
            System.out.println("Ennek nem szabad kiíródnia");
        }
        System.out.println("Teszt ||");

        if (igaz() || hamis()) {
            System.out.println("Az egyik feltétel igaz volt");
        }
        System.out.println("Teszt |");
        if (igaz() | hamis()) {
            System.out.println("Az egyik feltétel igaz volt");
        }
        System.out.println();
        System.out.println();
        System.out.println();


        Double eredmeny2 = null;
        switch (operand) {
            case "+":
                eredmeny2 = (double) szam1 + szam2;
                break;
            case "-":
                eredmeny2 = (double) szam1 - szam2;
                break;
            default:
                System.out.println("Ismeretlen operandus: " + operand);
        }
        System.out.println("Switch eredmeny: " + eredmeny2);

        Double eredmeny3 = null;
        switch (operand) {
            case "+":
                eredmeny3 = (double) szam1 + szam2;
            case "-":
                eredmeny3 = (double) szam1 - szam2;
                break;
            default:
                System.out.println("Ismeretlen operandus: " + operand);
        }
        System.out.println("Hibás Switch eredmeny: " + eredmeny3);
        System.out.println();
        System.out.println("Írj be valamit!");
        String bemenet = new Scanner(System.in).nextLine();

        boolean hosszabbMintHarom = bemenet.length() > 3;
        String eredmeny4 = hosszabbMintHarom ? "A beírt szöveg 3 karakternél hosszabb" : "A beírt szöveg 3 karakternél nem hosszabb";
        System.out.println(eredmeny4);
    }
}
