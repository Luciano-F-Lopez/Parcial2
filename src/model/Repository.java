/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MIPC
 */
class Repository<T extends Serializable> {
    private String filePath;
    private List<T> items;

    public Repository(String filepath, List<T> items) {
        this.filePath = filepath;
        this.items = items;
    }
    
    public static <T extends Serializable> Repository<T> loadFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<T> data = (List<T>) ois.readObject();
            return new Repository<>(filePath, data);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar datos desde el archivo.", e);
        }
    }
    
    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(items);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar datos en el archivo.", e);
        }
    }
    
     public void add(T item) {
        items.add(item);
    }
     
      public List<T> getAll() {
        return items;
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
}
