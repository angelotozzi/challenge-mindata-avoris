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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha1 = (Fecha) o;
        return fecha.equals(fecha1.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }
}
