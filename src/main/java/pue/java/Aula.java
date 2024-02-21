package pue.java;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Aula {
    public static final int MAXESTUDIANTES = 30 ;
    private int id;
    private Materias materias;
    private List<Estudiante> listaEstudiantes;
    private Profesor profesor;

    public boolean darClase() {
        //Comprueba la asistencia
        if(!profesor.asistir()) {
            throw new IllegalArgumentException("El profesor se encuentra ausente");
        }

        //Comprueba la materia del profesor y la materia que se requiere
        if(profesor.getMateria() != materias){
            throw new IllegalArgumentException("El profesor no imparte la materia demandada");
        }

        int nEstudiantes = listaEstudiantes.size();

        //Comprueba la cantidad de estudiantes
        if(nEstudiantes < MAXESTUDIANTES){
            throw new IllegalArgumentException("La cantidad de estudiantes no es suficiente");
        }
        return true;
    }

}