package com.example.demo;

import org.springframework.util.StringUtils;

import java.util.Objects;

public final class Materia {
//    @NotBlank
    private final String nombre;
//    @NotNull
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

}
