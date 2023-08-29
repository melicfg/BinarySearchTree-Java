/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author melic
 */
public class Libro {
    
    private int id;
    private String nombre;
    private int anio;
    
    public Libro(int id, String nombre, int anio){
    
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
    
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getAnio(){
        return this.anio;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setAnio(int anio){
        this.anio = anio;
    }
}
