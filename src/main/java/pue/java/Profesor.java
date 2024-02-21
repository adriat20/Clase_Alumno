package pue.java;

import com.github.javafaker.Faker;

import java.util.Random;

public class Profesor extends Persona {
    private Materias materia;

    public Profesor(String nombre, String apellido, String edad, char sexo, boolean disponibilidad, Materias materia) {
        super(nombre, apellido, edad, sexo, disponibilidad);
        this.materia = materia;
    }

    public Materias getMateria() {
        return materia;
    }

    public void setMateria(Materias materia) {
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
        Faker faker = new Faker();
        String nombre = faker.name().firstName();
        String apellido = faker.name().lastName();
        String edad = Integer.toString(faker.number().numberBetween(30, 68));
        char sexo = faker.options().option('M', 'F');
        //Ambas son correctas pero para una mejor depuracion (y no necesitar varios intentos) la he puesto estática
        Materias materia = Materias.MATEMATICAS;
        //Materias materia = Materias.values()[faker.random().nextInt(Materias.values().length)]; // seleccionar una materia aleatoria
        boolean disponibilidad = faker.bool().bool();
        return new Profesor(nombre, apellido, edad, sexo, disponibilidad, materia);
    }

}