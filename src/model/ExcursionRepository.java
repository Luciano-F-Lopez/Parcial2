/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MIPC
 */
public class ExcursionRepository implements Irepository<Excursion>{
    
    private List<Excursion> excursiones;
    private String filePath;
    private int ultimoId;
    
    public ExcursionRepository(String filePath){
        this.filePath = filePath;
        this.excursiones = new ArrayList<>();
        this.ultimoId = 1;
    }
    
    

    @Override
    public void add(Excursion excursion) {
        excursion.setId(ultimoId++);
        excursiones.add(excursion);
        try {
            save();
        } catch (IOException ex) {
            Logger.getLogger(ExcursionRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void remove(int id){
        excursiones.removeIf(filter)
    }
    
    private void save() throws FileNotFoundException, IOException{ 
     try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
         oos.writeObject(excursiones); 
     } catch(IOException e){
         e.printStackTrace();
     }  
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Excursion> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Excursion> findById(Predicate<Excursion> Criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Excursion> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
