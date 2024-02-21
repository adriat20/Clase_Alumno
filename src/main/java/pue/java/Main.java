package pue.java;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Materias materiaProfesorDisponible = Materias.MATEMATICAS;
        Materias materiaProfesorAusente = Materias.FISICA;
        Profesor profesor = Profesor.generaProfesor();
        List<Estudiante> estudiantes = Estudiante.generaEstudiantes();
        //Ordeno la lista alfabeticamente por el apellido
        estudiantes.stream()
                   .sorted(Comparator.comparing(Estudiante::getApellido))
                   .forEach(System.out::println);



        List<Aula> aulas = new ArrayList<>();
        aulas.add(new Aula(1, materiaProfesorDisponible, estudiantes, profesor));
        aulas.add(new Aula(2, materiaProfesorAusente, estudiantes, profesor));

        // Se recorren todas las aulas disponibles

        for (Aula aula : aulas) {
            if (aula.darClase()) {
                System.out.println("Se puede dar clase en el aula " + aula.getId());
                Profesor profesorAula = aula.getProfesor();
                List<Estudiante> estudiantesAula = aula.getListaEstudiantes();

                System.out.println("El profesor del aula es " + profesorAula.getNombre() + " " + profesorAula.getApellido() +
                        " de " + profesorAula.getEdad() + " años " + profesorAula.getSexo() + " e imparte la materia de " + profesorAula.getMateria() + "\n");
                System.out.println("Estudiantes asistentes\n");
                for(Estudiante estudiante : estudiantes){
                    System.out.println(estudiante);
                }
                System.out.println("Cantidad de alumnos aprobados: " + calcularAprobados(estudiantesAula));
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
}
