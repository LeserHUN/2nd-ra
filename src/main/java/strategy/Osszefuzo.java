package strategy;

import java.util.List;

public class Osszefuzo {
    public String osszefuz(List<String > darabok, Strategy strategy){
        return strategy.osszefuz(darabok);
    }
}
