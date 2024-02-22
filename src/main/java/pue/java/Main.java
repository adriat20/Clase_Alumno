package pue.java;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Creamos la clase
        Materias materiaProfesorDisponible = Materias.MATEMATICAS;
        Materias materiaProfesorAusente = Materias.FISICA;
        Profesor profesor = Profesor.generaProfesor();
        List<Estudiante> estudiantes = Estudiante.generaEstudiantes();


        List<Aula> aulas = new ArrayList<>();
        aulas.add(new Aula(1, materiaProfesorDisponible,  Estudiante.generaEstudiantes(), profesor));
        aulas.add(new Aula(2, materiaProfesorAusente,     Estudiante.generaEstudiantes(), profesor));


        // Se recorren todas las aulas disponibles
        for (Aula aula : aulas) {
            if (aula.darClase()) {

                System.out.println("\nSe puede dar clase en el aula " + aula.getId());
                System.out.println("El profesor es: " + profesor.getNombre() + " " + profesor.getApellido() + " " +
                        profesor.getEdad() + " años " + "sexo " + profesor.getSexo() + " e imparte " + profesor.getMateria() + "\n");

                List<Estudiante> estudiantesAula = aula.getListaEstudiantes();

                // Ordenar la lista de estudiantes alfabéticamente por apellido
                estudiantes.stream()
                           .sorted(Comparator.comparing(Estudiante::getApellido))
                           .forEach(System.out::println);

                System.out.println("\nCantidad de alumnos aprobados: " + calcularAprobados(estudiantesAula)[0] + "\n" +
                                   "Cantidad de alumnas aprobadas: " + calcularAprobados(estudiantesAula)[1]   + "\n"+
                                   "\nCantidad de alumnos suspensos: "   +  calcularSuspensos(estudiantesAula)[0] + "\n" +
                                   "Cantidad de alumnas suspensas: "   +  calcularSuspensos(estudiantesAula)[1] + "\n" +
                        "\nNota media de la clase de los alumnos: " + calcularMediaNotas(estudiantesAula)[0] + "\n"+
                        "Nota media de la clase de las alumnas: " + calcularMediaNotas(estudiantesAula)[1] + "\n"+
                        "\nNota media total de la clase: "          + calcularMediaNotas(estudiantesAula)[2] + "\n");
            }
        }
    }

    public static int[] calcularAprobados(List<Estudiante> estudiantes) {
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
        return new int[] {contadorM, contadorF};
    }


    public static int[] calcularSuspensos(List<Estudiante> estudiantes) {
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
        return new int[] {contadorM, contadorF};
    }


    public static float [] calcularMediaNotas(List<Estudiante> estudiantes) {
        float mediaTotal, mediaM, mediaF, acumuladorTotal = 0, acumuladorM = 0, acumuladorF = 0;
        int contadorTotal = 0, contadorM = 0, contadorF = 0;


        for (Estudiante estudiante : estudiantes) {
            if(estudiante.getSexo()=='M'){
            acumuladorM += estudiante.getCalificacion();
            contadorM++;
        } else if (estudiante.getSexo()=='F') {
                acumuladorF += estudiante.getCalificacion();
                contadorF++;
            }
            contadorTotal ++;
            acumuladorTotal += estudiante.getCalificacion();
            }

            //mediaM = acumuladorM / contadorM;
            mediaM     = contadorM     > 0 ? acumuladorM / contadorM :0;

            mediaF     = contadorF     > 0 ? acumuladorF / contadorF :0;

            mediaTotal = contadorTotal > 0 ? acumuladorTotal / contadorTotal : 0;


        return new float [] {mediaM,mediaF,mediaTotal} ;
    }
}
