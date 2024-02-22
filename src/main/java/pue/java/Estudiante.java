package pue.java;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Estudiante extends Persona {

    @Getter
    private float calificacion;
    //numero maximo de estudiantes que caben en la clase
    private int nEstudiantes = 30;

    public Estudiante(String nombre, String apellido, String edad, char sexo, boolean disponibilidad, float calificacion) {
        super(nombre, apellido, edad, sexo, disponibilidad);
        this.calificacion = calificacion;
    }


    @Override
    public boolean asistir() {
        Random r = new Random();
        int probabilidad = r.nextInt(100);

        return probabilidad < 60;
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
            String edad = Integer.toString(faker.number().numberBetween(18, 25));

            char sexo = faker.options().option('M', 'F');
            //Crea una disponibilidad aleatoria (true o false)
            //boolean disponibilidad = true;
            boolean disponibilidad = faker.bool().bool();
            float calificacion = faker.number().numberBetween(0, 10);

            // Crea una instancia de Estudiante y se agrega a la lista
            estudiantes.add(new Estudiante(nombre, apellido, edad, sexo, disponibilidad, calificacion));
        }

        return estudiantes;
    }
    static int[] calcularAprobados(List<Estudiante> estudiantes) {
        int contadorM = 0;
        int contadorF = 0;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCalificacion() >= 5) {
                if (estudiante.getSexo() == 'M') {
                    contadorM++;
                } else if (estudiante.getSexo() == 'F') {
                    contadorF++;
                }
            }
        }
        return new int[]{contadorM, contadorF};
    }


    static int[] calcularSuspensos(List<Estudiante> estudiantes) {
        int contadorM = 0;
        int contadorF = 0;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCalificacion() < 5) {
                if (estudiante.getSexo() == 'M') {
                    contadorM++;
                } else if (estudiante.getSexo() == 'F') {
                    contadorF++;
                }
            }
        }
        return new int[]{contadorM, contadorF};
    }


    static float[] calcularMediaNotas(List<Estudiante> estudiantes) {
        float mediaTotal, mediaM, mediaF, acumuladorTotal = 0, acumuladorM = 0, acumuladorF = 0;
        int contadorTotal = 0, contadorM = 0, contadorF = 0;


        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getSexo() == 'M') {
                acumuladorM += estudiante.getCalificacion();
                contadorM++;
            } else if (estudiante.getSexo() == 'F') {
                acumuladorF += estudiante.getCalificacion();
                contadorF++;
            }
            contadorTotal++;
            acumuladorTotal += estudiante.getCalificacion();
        }

        //mediaM = acumuladorM / contadorM;
        mediaM = contadorM > 0 ? acumuladorM / contadorM : 0;

        mediaF = contadorF > 0 ? acumuladorF / contadorF : 0;

        mediaTotal = contadorTotal > 0 ? acumuladorTotal / contadorTotal : 0;


        return new float[]{mediaM, mediaF, mediaTotal};
    }
}

