/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author MIPC
 */
public class GestorExcursiones {
    private Repository<Excursion> repository;
    
    public GestorExcursiones(String filePath){
        File file =new File(filePath);
        if (file.exists()){
            repository = Repository.loadFromFile(filePath)
        } else {
            repository = new Repository<>(filePath,new ArrayList<>());
        }
    }
}
