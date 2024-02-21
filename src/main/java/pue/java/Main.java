package pue.java;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Materias materiaProfesorDisponible = Materias.MATEMATICAS;
        Materias materiaProfesorAusente = Materias.FISICA;

        Profesor profesor = Profesor.generaProfesor();
        List<Estudiante> estudiantes = Estudiante.generaEstudiantes();
        Aula aula = new Aula(1, Materias.MATEMATICAS, estudiantes, profesor);

        if (aula.darClase()) {
            System.out.println("Se puede dar clase en el aula");
            System.out.println("El profesor del aula es " + profesor.getNombre() + " " + profesor.getApellido() +
                    " de " + profesor.getEdad() + " años " + profesor.getSexo() + " e imparte la materia de " + profesor.getMateria()+"\n");
            System.out.println("Los estudiantes son " + estudiantes+"\n");
            System.out.println("Cantidad de alumnos aprobados: " + calcularAprobados(estudiantes));
        }
    }

    public static int calcularAprobados(List<Estudiante>estudiantes){

        int contador = 0;
        for(Estudiante estudiante : estudiantes){
            if(estudiante.getCalificacion()>=5){
                contador++;
            }
        }
        return contador;

    }
}