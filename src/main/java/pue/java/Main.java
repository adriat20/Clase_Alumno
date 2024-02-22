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
        aulas.add(new Aula(1, materiaProfesorDisponible, estudiantes, profesor));
        //Creo un nuevo aula con la misma lista para no usar más memoria ya que la lógica es para que salga la excepcion
        aulas.add(new Aula(2, materiaProfesorAusente, estudiantes, profesor));


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

                System.out.println("\nCantidad de alumnos aprobados: " + calcularAprobados(estudiantesAula) + "\n" +
                        "Cantidad de alumnos suspensos: " + calcularSuspensos(estudiantesAula) + "\n" +
                        "Nota media de la clase: " + calcularMediaNotas(estudiantesAula) + "\n");
            }
        }
    }

    public static int calcularAprobados(List<Estudiante> estudiantes) {
        int contador = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCalificacion() >= 5) {
                contador++;
            }
        }
        return contador;
    }

    public static int calcularSuspensos(List<Estudiante> estudiantes) {
        int contador = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCalificacion() < 5) {
                contador++;
            }
        }
        return contador;
    }

    public static float calcularMediaNotas(List<Estudiante> estudiantes) {
        float media, acumulador = 0;
        int contador = 0;

        for (Estudiante estudiante : estudiantes) {
            acumulador += estudiante.getCalificacion();
            contador++;
        }

        media = acumulador / contador;

        return media;
    }
}
