package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.util.StringUtils;

import java.util.Objects;

public final class Materia {
//  @NotBlank
    private final String nombre;
//  @NotNull
//  @Size(min = 1, max = 10,message = "El rango de la calificación no es valido")
    private final Float calificacion;

    Materia(final String nombre, final Float calificacion) throws IllegalArgumentException{

        if(!StringUtils.hasLength(nombre)){
            throw new IllegalArgumentException("El nombre de la materia no puede estar vacio");
        }
        if(Objects.isNull(calificacion)){
            throw new IllegalArgumentException("La calificacion no puede estar vacia");
        }
        if(calificacion.floatValue() > 10 || calificacion.floatValue() < 1){
            throw new IllegalArgumentException("El rango de la calificación no es valido");
        }

        this.nombre = nombre;
        this.calificacion = calificacion;

    }

    public String getNombre(){
        return nombre;
    }

    public Float getCalificacion(){
        return calificacion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return nombre.equals(materia.nombre) && calificacion.equals(materia.calificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, calificacion);
    }
}
