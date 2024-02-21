package pue.java;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.Random;

public class Estudiante extends Persona {

    private float calificacion;
    //numero maximo de estudiantes que caben en la clase
    private int nEstudiantes = 30;

    public Estudiante(String nombre, String apellido, String edad, char sexo, boolean disponibilidad, float calificacion) {
        super(nombre, apellido, edad, sexo, disponibilidad);
        this.calificacion = calificacion;
    }

    public float getCalificacion() {
        return calificacion;
    }


    @Override
    public boolean asistir() {
        Random r = new Random();
        int probabilidad = r.nextInt(100);

        return probabilidad < 80;
    }

    public static List<Estudiante> generaEstudiantes() {
        // Creamos la lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();

        Faker faker = new Faker(new Locale("Es"));
        Random random = new Random();
        //int cantidadEstudiantes = 30;

        // Genera un número aleatorio entre 1 y el máximo de estudiantes
        int cantidadEstudiantes = random.nextInt(Aula.MAXESTUDIANTES) + 10;
        //System.out.println(cantidadEstudiantes);

        for (int i = 0; i < cantidadEstudiantes; i++) {
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            String edad = Integer.toString(faker.number().numberBetween(18, 20));
            char sexo = faker.options().option('M', 'F');
            // Crea una disponibilidad aleatoria (true o false)
            //boolean disponibilidad = true;
            boolean disponibilidad = faker.bool().bool();
            float calificacion = faker.number().numberBetween(0, 10);
            // Crea una instancia de Estudiante y se agrega a la lista
            estudiantes.add(new Estudiante(nombre, apellido, edad, sexo, disponibilidad, calificacion));
        }

        return estudiantes;
    }
}
