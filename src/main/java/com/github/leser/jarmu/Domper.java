package com.github.leser.jarmu;

import lombok.Data;

@Data
public class Domper { private final int kapacitas;
    private final int maxSebesseg;

    private boolean JarAMotor;
    private boolean platoNyitva;
    private int sebesseg;
    private int rakomany;

    public Domper(int kapacitas, int maxSebesseg) {
        this.kapacitas = kapacitas;
        this.maxSebesseg = maxSebesseg;
        System.out.println("A Dömper elkészült");
    }

    public void motorBeindit() {
        JarAMotor = true;
    }

    public void motorLeallit() {
        JarAMotor = false;
    }

    public void platoKinyit() {
        if (sebesseg != 0){
            throw new IllegalStateException("A Dömper halad. Sebesség: "+ sebesseg);
        }
        platoNyitva = true;

    }

    public void platoBecsuk() {
        platoNyitva = false;
    }

    public void elindul(Integer sebesseg) throws NemJarAMotorExeption {
        if (this.sebesseg != 0){
            throw new IllegalStateException("A Dömper már halad. Sebesség: "+ sebesseg);
        }
        if (platoNyitva){
            throw new IllegalStateException("A plató nyitva.");
        }
        if (!JarAMotor){
            throw new NemJarAMotorExeption();
        }
        if (sebesseg > maxSebesseg){
            throw new IllegalArgumentException(" Ez a jármű nem tud ilyen gyorsan menni, a max sebessége " + maxSebesseg);
        }
        this.sebesseg = sebesseg;
    }

    public void megall() {
        sebesseg = 0;
    }

    public void gyorsit(Integer sebesseg) throws NemJarAMotorExeption{
        int ujSebesseg = this.sebesseg + sebesseg;
        if (!JarAMotor){
            throw new NemJarAMotorExeption();
        }
        if (platoNyitva){
            throw new IllegalStateException("A plató nyitva.");
        }
        if (ujSebesseg > maxSebesseg){
            throw new IllegalArgumentException(" Ez a jármű nem tud ilyen gyorsan menni, a max sebessége " + maxSebesseg);
        }
        this.sebesseg = ujSebesseg;
    }

    public void felrakod(Integer rakomany) {
        int ujRakomany = this.rakomany + rakomany;

        if (ujRakomany > kapacitas){
            throw new TulSokRakomanyException(ujRakomany + " Meghaladja a maximum kapacitást");
        }


        this.rakomany = ujRakomany;
    }

    public void lerakod() {
        if (!platoNyitva){
            throw new IllegalStateException("A plató nincs nyitva.");
        }

        rakomany = 0;
    }

    @Override
    public String toString() {
        return "["
                + "kapacitas: " + kapacitas
                + ", JarAMotor: " + JarAMotor
                + ", platoNyitva: " + platoNyitva
                + ", sebesseg: " + sebesseg
                + ", rakomany: " + rakomany
                + ", maxSebesseg " + maxSebesseg
                + "]";
    }
}