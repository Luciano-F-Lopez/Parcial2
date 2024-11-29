/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MIPC
 */
class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int idExcursion;
    private String cliente;
    private String fechaReserva;
    private double precio;
    private boolean pagoConfirmado;

    public Reserva(int idExcursion, String cliente, double precio){
        
        if(cliente == null){
            throw new IllegalArgumentException("el cliente no puede ser nullo");  
        }
        
        if(precio < 0){
            throw new IllegalArgumentException("el precio no puede ser menor que 0");  
        }
        
        this.idExcursion = idExcursion;
        this.cliente = cliente;
        this.fechaReserva = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.precio = precio;
        this.pagoConfirmado = false;
    }
    
    public boolean confirmarPago(){
        this.pagoConfirmado = true;
        return pagoConfirmado;
    }
    
    public String detalleReserva() {
        return String.format(
            "Reserva:\nID Excursión: %d\nCliente: %s\nFecha de Reserva: %s\nPrecio: %.2f\nPago Confirmado: %s",
            idExcursion, cliente, fechaReserva, precio, pagoConfirmado ? "Sí" : "No"
        );
    }

    public int getIdExcursion() {
        return idExcursion;
    }

    public void setIdExcursion(int idExcursion) {
        this.idExcursion = idExcursion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        if(cliente == null){
            throw new IllegalArgumentException("el cliente no puede ser nullo");  
        }
        this.cliente = cliente;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio < 0){
            throw new IllegalArgumentException("el precio no puede ser menor que 0");  
        }
        this.precio = precio;
    }

    public boolean isPagoConfirmado() {
        return pagoConfirmado;
    }

    public void setPagoConfirmado(boolean pagoConfirmado) {
        this.pagoConfirmado = pagoConfirmado;
    }
    
    
    
    
    
}
