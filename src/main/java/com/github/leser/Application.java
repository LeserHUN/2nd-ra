package com.github.leser;

public class Application {
    public static void main(String[] args) {
        Valami valami = new Valami();
        valami.setErtek("wertwrt");

        System.out.println("Érték: " + valami.getErtek());
        System.out.println("Valami: " + valami.toString());

        Valami2 valami2 = new Valami2("sdgferwag");
        valami2.setAsd(true);
        System.out.println("Valami2: " + valami2);

        valami2.print(null);

        Valami3.Valami3Builder valami3Builder = Valami3.builder();
        valami3Builder.ertek("adfa");
        Valami3 valami3 = valami3Builder.build();
    }
}
