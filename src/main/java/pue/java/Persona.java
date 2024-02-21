package pue.java;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Persona {

    private String nombre;
    private String apellido;
    private String edad;
    private char sexo;
    private boolean disponibilidad;

    public abstract boolean asistir();





}
