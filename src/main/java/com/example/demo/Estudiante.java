package com.example.demo;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Collections;

public final class Estudiante {
//  Generalmente las validaciones de los campos las realizo con anotaciones de jakarta.validation.constraints:
//  @NotBlank para tipos de datos String, de modo que no lleguen campos nulos ni espacios en blanco.
//  @NotNull para numericos y colecciones.
//  Estas anotaciones al concretarse la validacion arrojan la exepción MethodArgumentNotValidException.
//  Para tratar las validaciones lanzadas en la validacion de entidades y metodos del controller
//  hago utilizacion de una clase ControllerAdvice. Con el fin de centralizar todo el manejo de errores
//  en una sola clase, con una respuesta armada a medida, evitando asi la utilizacion de try catch en cada metodo
    //@NotBlank
    private final String nombre;
    //@NotNull
    //@Min(value = 18, message = "La edad no debe ser menor a 18 años")
    private final Integer edad;
    //@NotNull
    private final Fecha fechaFinalización;
    //@NotNull
    private final List<Materia> materiasCursadas;

    public Estudiante(final String nombre, final Integer edad, final Fecha fechaFinalización, final List<Materia> materiasCursadas) throws IllegalArgumentException {

        if(!StringUtils.hasLength(nombre)){
            throw new IllegalArgumentException("El nombre del estudiante no puede estar vacio");
        }
        if(Objects.isNull(edad)){
            throw new IllegalArgumentException("La edad no puede estar vacia");
        }
        if(edad.intValue() < 18){
            throw new IllegalArgumentException("La edad no debe ser menor a 18 años");
        }
        if(Objects.isNull(fechaFinalización)){
            throw new IllegalArgumentException("La fechaFinalización no debe estar vacia");
        }
        if(CollectionUtils.isEmpty(materiasCursadas)){
            throw new IllegalArgumentException("La lista de materias cursadas no debe estar vacia");
        }

        this.nombre = nombre;
        this.edad = edad;
        this.fechaFinalización = fechaFinalización;
        this.materiasCursadas = materiasCursadas;
    }

    public String getNombre(){
        return nombre;
    }

    public Integer getEdad(){
        return edad;
    }

    public String getFechaFinalización (){
        return fechaFinalización.getFecha();
    }

    public List<Materia> getMateriasCursadas (){
        return Collections.unmodifiableList(materiasCursadas);
    }

}
