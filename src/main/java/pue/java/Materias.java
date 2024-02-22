package pue.java;

import java.util.Random;

public enum Materias {
MATEMATICAS, FILOSOFIA, FISICA;


    public static Materias materiasRandom(){

    Materias[] materias= Materias.values();
    Random r = new Random();
    int indice = r.nextInt(materias.length);

    return materias[indice];

    }
}
