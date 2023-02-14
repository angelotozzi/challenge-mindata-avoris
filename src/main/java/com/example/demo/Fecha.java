package com.example.demo;

import java.time.LocalDateTime;

import java.util.Objects;

public final class Fecha {
//    @NotNull
    private final String fecha;

    Fecha(final LocalDateTime fecha) throws IllegalArgumentException{

        if(Objects.isNull(fecha)){
            throw new IllegalArgumentException("La fecha no puede estar vacia");
        }

        this. fecha = fecha.getDayOfMonth()+"/"+fecha.getMonthValue();;

    }

    public String getFecha(){
        return this.fecha;
    }

}
