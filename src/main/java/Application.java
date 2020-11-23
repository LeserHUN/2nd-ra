import exception.NemJarAMotorExeption;
import jarmu.Domper;

public class Application {
    public static void main(String[] args) {
        Domper domper = new Domper(100, 90);
        domper.felrakod(99);
        System.out.println("felrakod" + domper);

        domper.motorBeindit();
        System.out.println("Motor beindít" + domper);

        try {
            domper.elindul(10);
        } catch (NemJarAMotorExeption ex){
            System.out.println("A motor nem megy. Most beindítom");
            domper.motorBeindit();
            try {
                domper.elindul(10);
            } catch (NemJarAMotorExeption e) {
                throw new RuntimeException("Nem sikerült elindítani a motort", e);
            }
        }
        System.out.println("Elindul 10-el "+ domper);

        try {
            domper.gyorsit(150);
        } catch (NemJarAMotorExeption ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException e){
            System.out.println("Ennyivel nem tudok mennyi. Kérlek lassíts.");
            try {
                domper.gyorsit(50);
            } catch (NemJarAMotorExeption ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Gyorsít 40-el" + domper);

        domper.megall();
        System.out.println("Dömper megáll" + domper);

        domper.platoKinyit();
        System.out.println("Dömper plató kinyit" + domper);

        domper.lerakod();
        System.out.println("Dömper lerakod" + domper);

        domper.platoBecsuk();
        System.out.println("Dömper plató becsuk" + domper);

        domper.motorLeallit();
        System.out.println("Dömper leállít" + domper);
    }
}
