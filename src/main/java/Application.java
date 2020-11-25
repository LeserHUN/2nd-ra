import Chain_of_resposibility.ElsoLepes;
import Chain_of_resposibility.Lepes;
import Chain_of_resposibility.MasodikLepes;
import Facade.AutoMosoFacade;
import adapter.Auto;
import adapter.AutoMoso;
import adapter.AutoMosoAdapter;
import adapter.Kocsi;
import builder.Dobokocka;
import builder.DobokockaBuilder;
import decorator.AutoMosoSzarito;
import observer.Figyelo;
import observer.Subject;
import proxy.AutoMosoProxy;
import strategy.Concatenator;
import strategy.Joiner;
import strategy.Osszefuzo;
import template_method.TemplateSub_class;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        //Builder
        Dobokocka epitettKocka = new DobokockaBuilder()
                .elsoOldal(2)
                .masodikOldal(4)
                .harmadikOldal(8)
                .negyedikOldal(16)
                .otodikOldal(32)
                .hatodikOldal(64)
                .build();
        //Adapter
        Kocsi kocsi = new Kocsi("Fejrearri");
        AutoMosoAdapter autoMosoAdapter = new AutoMosoAdapter(new AutoMoso());
        autoMosoAdapter.mos(kocsi);

        //Decorator
        AutoMosoSzarito autoMosoSzarito = new AutoMosoSzarito(new AutoMoso());
        autoMosoSzarito.mos(new Auto("Toyota"));

        //Facade
        AutoMosoFacade autoMosoFacade = new AutoMosoFacade();
        autoMosoFacade.autoMosas(new Auto("lamborghini"));
        autoMosoFacade.kocsiMosas(kocsi);

        //Proxy
        AutoMosoProxy autoMosoProxy = new AutoMosoProxy();
        for (int i = 0; i < 15; i++) {
            autoMosoProxy.mos(new Auto("KicsiKocsi"));
        }

        //Chain of Responsibility
        List<Lepes> lepesek = Arrays.asList(new ElsoLepes(), new MasodikLepes());
        for (Lepes lepes : lepesek) {
            lepes.lep();
        }

        //Observer
        Figyelo figyelo = new Figyelo();
        Subject subject = new Subject();
        subject.addObserver(figyelo);
        subject.setAllapot("Új állapot");

        //Strategy
        Osszefuzo osszefuzo = new Osszefuzo();
        List<String> darabok = Arrays.asList("ElsőSzó", "MásodikSzó");
        System.out.println(osszefuzo.osszefuz(darabok, new Concatenator()));
        System.out.println(osszefuzo.osszefuz(darabok, new Joiner()));

        //TemplateMethod
        new TemplateSub_class().businessLogika();

    }
}
