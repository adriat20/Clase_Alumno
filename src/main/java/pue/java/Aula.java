package pue.java;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Aula {
    public static final int MAXESTUDIANTES = 30;
    private int id;
    private Materias materias;
    private List<Estudiante> listaEstudiantes;
    private Profesor profesor;

    public boolean darClase() {
        try {
            // Comprueba la asistencia del profesor
            if (!profesor.asistir()) {
                throw new IllegalArgumentException("El profesor del aula " + getId() + " se encuentra ausente");
            }

            // Comprueba la materia del profesor y la materia que se requiere
            if (profesor.getMateria() != materias) {
                throw new IllegalArgumentException("El profesor del aula " + getId() + " imparte la materia de "
                        + getMaterias() + ", no de " + profesor.getMateria());
            }

            // Comprueba la cantidad de estudiantes
            int nEstudiantes = listaEstudiantes.size();
            if (nEstudiantes < 15) {
                throw new IllegalArgumentException("La cantidad de estudiantes del aula " + getId() + " es menor que el mínimo requerido (15)");
            } else if (nEstudiantes > MAXESTUDIANTES) {
                throw new IllegalArgumentException("La cantidad de estudiantes del aula " + getId() + " excede el máximo permitido (30)");
            }

            // Si todas las condiciones se cumplen, se puede dar clase en el aula
            return true;
        } catch (IllegalArgumentException e) {
            // Captura la excepción y la maneja
            System.out.println("\nExcepción en el aula " + getId() + ": " + e.getMessage());
            return false;
        }
    }


}
