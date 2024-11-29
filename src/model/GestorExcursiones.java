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
public class GestorExcursiones {
    private Repository<Excursion> repository;
    
    public GestorExcursiones(String filePath){
        File file =new File(filePath);
        if (file.exists()){
            repository = Repository.loadFromFile(filePath);
        } else {
            repository = new Repository<>(filePath,new ArrayList<>());
        }
    }
    
    public boolean agregarExcursion(Excursion excursion){
        if(excursion == null){
            throw new IllegalArgumentException("la excursion no puede ser nula"); 
        }
        repository.add(excursion);
        repository.save();
        return true;
    }
    
    public Optional<Excursion> buscarPorId(int id){
        return repository.getAll().stream().filter(excursion -> excursion.getId() == id).findFirst();
    }
    
    public List<Excursion> filtrarExcursion(Predicate<Excursion> criterio){
        return repository.getAll().stream().filter(criterio).toList();
    }
    
    public List <Excursion> consultarExcursionesPorPrecio(double precioMin){
        if (precioMin < 0){
            throw new IllegalArgumentException("el precio minimo no puede ser menor a 0"); 
        }
        return repository.getAll().stream().filter(excursion -> excursion.calcularPrecioFinal() >= precioMin).toList();
    }
    
}
