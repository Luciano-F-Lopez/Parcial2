/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MIPC
 */
public abstract class Excursion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static int idCounter = 1;
    private int id;
    private String titulo;
    private double precioBase;
    private int cupoMaximo;
    private transient GestorReservas gestorReservas;
    private List<String> actividades;

    public Excursion(String titulo,double precioBase,int cupoMaximo) {
        this.id = idCounter++;
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.cupoMaximo = cupoMaximo;
        this.gestorReservas = new GestorReservas();
        this.actividades = new ArrayList();
    }
    
    public boolean realizarReserva(String cliente){
        if(cliente == null){
            throw new IllegalArgumentException("El cliente no puede ser nulo"); 
        }
        return gestorReservas.realizarReserva(cliente,cupoMaximo);
    }
    
    public void agregarActividad(String actividad){
        if(actividad == null){
            throw new IllegalArgumentException("la actividad no puede ser nula"); 
        }
        actividades.add(actividad);
    }
    
    public String mostrarResumen() {
        String resumen = String.format(
            "Excursión: %s\nID: %d\nPrecio Base: %.2f\nCupo Máximo: %d\nCupo Disponible: %d\nActividades: %s",
            titulo, id, precioBase, cupoMaximo, gestorReservas.getCupoDisponible(cupoMaximo), actividades
        );
        return resumen;
    } 
    
    
    public String generarFilepath(){
        return String.format("reservas_excursion_{id}.dat", id);
    }
    
    private Optional<List<Reserva>> traerReservas(){
        return gestorReservas.traerReservas(generarFilepath());
    } 

    public abstract double calcularPrecioFinal();
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public GestorReservas getGestorReservas() {
        return gestorReservas;
    }

    public void setGestorReservas(GestorReservas gestorReservas) {
        this.gestorReservas = gestorReservas;
    }

    public List<String> getActividades() {
        return actividades;
    }

    public void setActividades(List<String> actividades) {
        this.actividades = actividades;
    }
    
    
    
    
    
}
