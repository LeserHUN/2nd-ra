package proxy;

import adapter.Auto;
import adapter.AutoMoso;

public class AutoMosoProxy {
    private AutoMoso autoMoso = null;
    private Integer mososzerMennyiseg = 0;

    public void mos(Auto auto) {
        if (autoMoso == null) {
            System.out.println("Nincs autómosónk, vegyönk egyet!");
            autoMoso = new AutoMoso();
        }
        if (mososzerMennyiseg == 0) {
            utantolt();
        }
        autoMoso.mos(auto);

        mososzerMennyiseg--;
        System.out.println("Mosás kész. " + mososzerMennyiseg + "mosószer maradt.");
    }

    private void utantolt() {
        System.out.println("Utántöltés...");
        mososzerMennyiseg = 5;
    }
}
