/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author MIPC
 */
public interface Irepository<T> {
    void add (T entity);
    
    void remove(int id);
    
    Optional<T> findById(int id);
    
    List<T> findById(Predicate<T> Criterio);
    
    List<T> getAll();
    
    
}
