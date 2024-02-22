package pue.java;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.Locale;
import java.util.Random;

@Getter
public class Profesor extends Persona {
    private Materias materia;

    public Profesor(String nombre, String apellido, String edad, char sexo, boolean disponibilidad, Materias materia) {
        super(nombre, apellido, edad, sexo, disponibilidad);
        this.materia = materia;
    }

    @Override
    public boolean asistir() {
        Random r = new Random();
        int probabilidad = r.nextInt(100);
        //System.out.println(probabilidad);
        if (probabilidad < 20) {
            //System.out.println(probabilidad);
            return false; // 20% de probabilidad de no asistir
        }
        return true;
    }

    public static Profesor generaProfesor() {
        Faker faker = new Faker(new Locale("Es"));
        String nombre = faker.name().firstName();
        String apellido = faker.name().lastName();
        String edad = Integer.toString(faker.number().numberBetween(30, 68));
        char sexo = faker.options().option('M', 'F');
        //Ambas son correctas pero para una mejor práctica utilizo el metodo random
        //Materias materia = Materias.MATEMATICAS;
        //Materias materia = Materias.values()[faker.random().nextInt(Materias.values().length)]; // seleccionar una materia aleatoria
        Materias materias = Materias.materiasRandom();
        boolean disponibilidad = faker.bool().bool();

        return new Profesor(nombre, apellido, edad, sexo, disponibilidad, materias);
    }

}