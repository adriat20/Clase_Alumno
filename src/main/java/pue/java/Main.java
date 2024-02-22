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
        aulas.add(new Aula(1, materiaProfesorDisponible, Estudiante.generaEstudiantes(), profesor));
        aulas.add(new Aula(2, materiaProfesorAusente, Estudiante.generaEstudiantes(), profesor));


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

                System.out.println("\nCantidad de alumnos aprobados: " + Estudiante.calcularAprobados(estudiantesAula)[0] + "\n" +
                        "Cantidad de alumnas aprobadas: " + Estudiante.calcularAprobados(estudiantesAula)[1] + "\n" +
                        "\nCantidad de alumnos suspensos: " + Estudiante.calcularSuspensos(estudiantesAula)[0] + "\n" +
                        "Cantidad de alumnas suspensas: " + Estudiante.calcularSuspensos(estudiantesAula)[1] + "\n" +
                        "\nNota media de la clase de los alumnos: " + Estudiante.calcularMediaNotas(estudiantesAula)[0] + "\n" +
                        "Nota media de la clase de las alumnas: " + Estudiante.calcularMediaNotas(estudiantesAula)[1] + "\n" +
                        "\nNota media total de la clase: " + Estudiante.calcularMediaNotas(estudiantesAula)[2] + "\n");
            }
        }
    }
}

