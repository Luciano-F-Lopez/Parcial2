/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MIPC
 */
public class ExcursionAventura extends Excursion {

    private int nivelDificultad;
    private double seguroAdicional;

    public ExcursionAventura(String titulo, double precioBase, int cupoMaximo, int nivelDificultad, double seguroAdicional) {
        super(titulo, precioBase, cupoMaximo);
        
        if(nivelDificultad < 1 || nivelDificultad > 5){
            throw new IllegalArgumentException("el nivelDificultad debe estar entre el 1 y el 5");  
        }
        
        if(seguroAdicional < 0){
          throw new IllegalArgumentException("el seguro Adicional no puede ser negativo");  
        }
        
        this.nivelDificultad = nivelDificultad;
        this.seguroAdicional = seguroAdicional;
    }

    @Override
    public double calcularPrecioFinal() {
       return (getPrecioBase() * (1 + 0.1 * nivelDificultad)) + seguroAdicional;
    }
    
    public String consejosSeguridad(){
        switch(nivelDificultad){
            case 1:
                return "Nivel 1: Mantén una buena hidratación";
            case 2:
                return "Nivel 2: No camines solo, mantén el grupo";
            case 3:
                return "Nivel 3: Haz estiramientos antes de caminar";
            case 4:
                return "Nivel 4: Toma descansos regulares";
            case 5:
                return "Nivel 5: Actúa rápidamente ante incidentes";
                
            default:
                return "Nivel de dificultad no valido";
        }      
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        if(nivelDificultad < 1 || nivelDificultad > 5){
            throw new IllegalArgumentException("el nivelDificultad debe estar entre el 1 y el 5");  
        }
        this.nivelDificultad = nivelDificultad;
    }

    public double getSeguroAdicional() {
        return seguroAdicional;
    }

    public void setSeguroAdicional(double seguroAdicional) {
        if(seguroAdicional < 0){
          throw new IllegalArgumentException("el seguro Adicional no puede ser negativo");  
        }
        this.seguroAdicional = seguroAdicional;
    }
    
    public String mostrarResumen(){
        return super.mostrarResumen() + String.format("\nNivel de Dificultad: %d\nSeguro Adicional: %.2f\nConsejos de Seguridad: %s",
                             nivelDificultad, seguroAdicional, consejosSeguridad());
    }
    
    
    
    
    
}
