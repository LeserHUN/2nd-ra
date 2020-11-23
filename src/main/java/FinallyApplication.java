public class FinallyApplication {
    public static void main(String[] args) {
        try {
            if (true) {
                throw new RuntimeException(" : Hiba vagyok");
            }
            System.out.println("Nem fogok kiírodni mert előttem hiba lett dobva");

        } catch (RuntimeException e) {
            System.out.println("Elkaptam a hibát" + e.getMessage());
        } finally {
            System.out.println("Én mindig lefutok");
        }


        try {
            if (true) {
                throw new RuntimeException("Hiba vagyok");
            }
            System.out.println("Nem fogok kiírodni mert előttem hiba lett dobva");

        } finally {
            System.out.println("Mondtam, hogy én mindig lefutok");
        }
    }
}
