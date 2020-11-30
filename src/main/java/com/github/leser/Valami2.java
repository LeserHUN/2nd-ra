package com.github.leser;

import lombok.Data;
import lombok.NonNull;

@Data
public class Valami2 {
    @NonNull
    private final String ertek;
    private Boolean asd;

    public void print(@NonNull String param) {
        @NonNull String valami = null;
        System.out.println(toString() + " " + param);
    }
}
