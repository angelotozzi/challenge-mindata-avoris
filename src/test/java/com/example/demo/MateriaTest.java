package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MateriaTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getNombre() {
    }

    @Test
    void getCalificacion() {
    }

    @Test
    public void testConstructorOK(){

        Fecha fechaFinalizacion = new Fecha(LocalDateTime.now());

        List<Materia> materiasCursadas = new ArrayList<Materia>();

        materiasCursadas.add(new Materia("Matematicas", 9f));

        Estudiante estudiante = new Estudiante("Juan", 18, fechaFinalizacion, materiasCursadas);

        assertEquals("Juan", estudiante.getNombre());
        assertEquals(18, estudiante.getEdad());
        assertEquals(LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue(), estudiante.getFechaFinalización());
        assertEquals(materiasCursadas, estudiante.getMateriasCursadas());
    }

    @Test
    public void testConstructorExceptionNombre(){

        Fecha fechaFinalizacion = new Fecha(LocalDateTime.now());

        List<Materia> materiasCursadas = new ArrayList<Materia>();

        materiasCursadas.add(new Materia("Matematicas", 9f));

        assertThrows(IllegalArgumentException.class, () -> new Estudiante("", 18, fechaFinalizacion, materiasCursadas),"El nombre del estudiante no puede estar vacio");

    }

    @Test
    public void testConstructorExceptionEdad(){

        Fecha fechaFinalizacion = new Fecha(LocalDateTime.now());

        List<Materia> materiasCursadas = new ArrayList<Materia>();

        materiasCursadas.add(new Materia("Matematicas", 9f));

        assertThrows(IllegalArgumentException.class, () -> new Estudiante("Juan",  null, fechaFinalizacion, materiasCursadas),"La edad no puede estar vacia");

    }

    @Test
    public void testConstructorExceptionRangoEdad(){

        Fecha fechaFinalizacion = new Fecha(LocalDateTime.now());

        List<Materia> materiasCursadas = new ArrayList<Materia>();

        materiasCursadas.add(new Materia("Matematicas", 9f));

        assertThrows(IllegalArgumentException.class, () -> new Estudiante("Juan",  17, fechaFinalizacion, materiasCursadas),"La edad no debe ser menor a 18 años");

    }

    @Test
    public void testConstructorExceptionFecha(){

        List<Materia> materiasCursadas = new ArrayList<Materia>();

        materiasCursadas.add(new Materia("Matematicas", 9f));

        assertThrows(IllegalArgumentException.class, () -> new Estudiante("Juan",  18, null, materiasCursadas),"La fechaFinalización no debe estar vacia");

    }

    @Test
    public void testFechaEqualsOk(){
        Fecha fecha = new Fecha(LocalDateTime.now());
        Fecha fecha2 = new Fecha(LocalDateTime.now());
        assertTrue(fecha.getFecha().equals(fecha2.getFecha()));
    }

    @Test
    public void testFechaEqualsKo(){
        Fecha fecha = new Fecha(LocalDateTime.now());
        Fecha fecha2 = new Fecha(LocalDateTime.of(2023,02,02,17,30));
        assertFalse(fecha.getFecha().equals(fecha2.getFecha()));
    }

    @Test
    public void testFechaHashCodeOk(){
        Fecha fecha = new Fecha(LocalDateTime.now());
        Fecha fecha2 = fecha;
        assertTrue(fecha.hashCode() == fecha2.hashCode());
    }

    @Test
    public void testFechaHashCodeKo(){
        Fecha fecha = new Fecha(LocalDateTime.now());
        Fecha fecha2 = new Fecha(LocalDateTime.of(2023,02,02,17,30));
        assertFalse(fecha.hashCode() == fecha2.hashCode());
    }

    @Test
    public void testConstructorExceptionFechaNull(){

        List<Materia> materiasCursadas = new ArrayList<Materia>();

        materiasCursadas.add(new Materia("Matematicas", 9f));

        assertThrows(IllegalArgumentException.class, () -> new Fecha(null), "La fecha no puede estar vacia");

    }

    @Test
    public void testConstructorExceptionMateriaNombre(){

        assertThrows(IllegalArgumentException.class, () -> new Materia("", 9f), "El nombre de la materia no puede estar vacio");

    }

    @Test
    public void testMateriaNombreEqualsOk(){
        Materia materia = new Materia("Matematica", 9f);
        Materia materia2 = new Materia("Matematica", 9f);
        assertTrue(materia.getNombre().equals(materia2.getNombre()));
    }

    @Test
    public void testMateriaNombreEqualsKo(){
        Materia materia = new Materia("Matematica", 9f);
        Materia materia2 = new Materia("Historia", 9f);
        assertFalse(materia.getNombre().equals(materia2.getNombre()));
    }

    @Test
    public void testMateriaNombreHashCodeOk(){
        Materia materia = new Materia("Matematica", 9f);
        Materia materia2 = materia;
        assertTrue(materia.hashCode() == materia2.hashCode());
    }

    @Test
    public void testMateriaNombreHashCodeKo(){
        Materia materia = new Materia("Matematica", 9f);
        Materia materia2 = new Materia("Historia", 9f);
        assertFalse(materia.hashCode() == materia2.hashCode());
    }

    @Test
    public void testConstructorExceptionMateriasCalificacion(){

        assertThrows(IllegalArgumentException.class, () -> new Materia("Matematicas", null), "La calificacion no puede estar vacia");

    }

    @Test
    public void testConstructorExceptionMateriasCalificacionFueraRango(){

        assertThrows(IllegalArgumentException.class, () -> new Materia("Matematicas", 11f), "El rango de la calificación no es valido");

    }

    @Test
    public void testConstructorExceptionMateriasCursadasNull(){

        Fecha fechaFinalizacion = new Fecha(LocalDateTime.now());

        List<Materia> materiasCursadas = new ArrayList<Materia>();

        assertThrows(IllegalArgumentException.class, () -> new Estudiante("Juan",  18, fechaFinalizacion, materiasCursadas),"La lista de materias cursadas no debe estar vacia");

    }

}