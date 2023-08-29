/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author melic
 */
public class Nodo {
    
    public Nodo padre;
    public Nodo derecha;
    public Nodo izquierda;
    public int llave;
    public Libro contenido;
    
    public Nodo(int llave, Libro contenido) {
        this.contenido = contenido;
        this.izquierda = null;
        this.derecha = null;
        this.llave = llave;
        this.padre = null;
    }
    
    
}
