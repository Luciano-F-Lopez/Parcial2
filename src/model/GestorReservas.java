/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author MIPC
 */
public class GestorReservas {
    
    private Repository<Reserva> repository;
    private final int cupoMaximo;
    
    public GestorReservas(String filePath,int cupoMaximo){
        if(cupoMaximo <= 0){
            throw new IllegalArgumentException("el cupo maximo no puede ser menor ni igual a 0"); 
        } 
        this.cupoMaximo = cupoMaximo;
        
        File file = new File(filePath);
        if (file.exists()){
            this.repository = Repository.loadFromFile(filePath);
        } else {
            this.repository = new Repository<>(filePath,new ArrayList<>());
        }
    }
    

    public boolean realizarReserva(Reserva reserva ) {
        if(reserva == null){
            throw new IllegalArgumentException("la reserva no puede ser nula"); 
        } 
        
       if(repository.getAll().size() >= cupoMaximo){
           System.out.println("No hay cupos disponibles");
           return false;       
       }
       repository.add(reserva);
       repository.save();
       return true;
    }
   
    public List<Reserva> getReservas(){
        return repository.getAll();
    }
    
    
    public double calcularIngresos(Predicate<Reserva> filtro){
        return repository.getAll().stream().filter(filtro).mapToDouble(Reserva::getPrecio).sum();
    }
    
    public double  calcularIngresosTotales(){
        return calcularIngresos(Reserva::isPagoConfirmado);
    }
    
    
    Optional<List<Reserva>> traerReservas(String generarFilepath) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
