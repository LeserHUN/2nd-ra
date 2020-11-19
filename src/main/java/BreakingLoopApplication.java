public class BreakingLoopApplication {

    public static void main(String[] args) {

        int counter = 0;
        while (true) {
            counter++;
            System.out.println("Counter: " + counter);
            if (counter > 9) {
                break;
            }
        }
        for(int i = 0; i < 100; i++) {
            int maradek = i % 2;
            if (maradek == 0) {
                continue;
            }

            System.out.println("Index: " + i);
        }
    }
}
