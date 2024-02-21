package pue.java;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Materias materiaProfesorDisponible = Materias.MATEMATICAS;
        Materias materiaProfesorAusente = Materias.FISICA;
        Profesor profesor = Profesor.generaProfesor();
        List<Estudiante> estudiantes = Estudiante.generaEstudiantes();

        //Ordeno la lista alfabeticamente por el apellido
        System.out.println("----- Lista de alumnos -----");
        estudiantes.stream()
                   .sorted(Comparator.comparing(Estudiante::getApellido))
                   .forEach(System.out::println);



        List<Aula> aulas = new ArrayList<>();
        aulas.add(new Aula(1, materiaProfesorDisponible, estudiantes, profesor));
        aulas.add(new Aula(2, materiaProfesorAusente, estudiantes, profesor));

        // Se recorren todas las aulas disponibles

        for (Aula aula : aulas) {
            if (aula.darClase()) {
                System.out.println("\nSe puede dar clase en el aula " + aula.getId());
                Profesor profesorAula = aula.getProfesor();
                estudiantes= aula.getListaEstudiantes();

                System.out.println("El profesor del aula es " + profesorAula.getNombre() + " " + profesorAula.getApellido() +
                        " de " + profesorAula.getEdad() + " años " + profesorAula.getSexo() + " e imparte la materia de " + profesorAula.getMateria() + "\n");
                System.out.println("----- Estudiantes asistentes -----\n");
                for(Estudiante estudiante : estudiantes){
                    System.out.println(estudiante);
                }
                System.out.println("Cantidad de alumnos aprobados: " + calcularAprobados(estudiantes)+"\n"+
                                   "Cantidad de alumnos suspensos: " + calcularSuspensos(estudiantes)+"\n"+
                                   "Nota media de la clase: "        + mediaNotas(estudiantes));

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

    public static int calcularSuspensos(List<Estudiante>estudiantes){
        int contador = 0;
        for (Estudiante estudiante : estudiantes){
            if(estudiante.getCalificacion()<5){
                contador++;
            }
        }

        return contador;

    }

    public static float mediaNotas (List<Estudiante> estudiantes){

        float media, acumulador = 0;
        int contador =0;

        for(Estudiante estudiante : estudiantes){
            acumulador += estudiante.getCalificacion();
            contador++;
        }

        media = acumulador / contador;

        return media;

    }
}
