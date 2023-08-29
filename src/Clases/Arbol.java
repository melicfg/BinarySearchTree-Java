/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author melic
 */
public class Arbol {
    
    Nodo raiz;
    
    public Arbol(){
        raiz = null;
    }
    
    public void insertar(int llave, Libro contenido) {
        raiz = insertarRecursivo(raiz, llave, contenido, null);
    }
    
    public class LlaveDuplicadaException extends RuntimeException {
        public LlaveDuplicadaException(String mensaje) {
            super(mensaje);
        }
    }
    
    public class LlaveInexistenteException extends RuntimeException {
        public LlaveInexistenteException(String mensaje) {
            super(mensaje);
        }
    }

    private Nodo insertarRecursivo(Nodo raiz, int llave, Libro contenido, Nodo padre) {
        if (raiz == null) {
            Nodo nuevoNodo = new Nodo(llave, contenido);
            nuevoNodo.padre = padre;
            return nuevoNodo;
        }
        
        if (buscar(llave)!= null){
            throw new LlaveDuplicadaException("Llave duplicada: " + llave);
        }

        if (llave < raiz.llave) {
            raiz.izquierda = insertarRecursivo(raiz.izquierda, llave, contenido, raiz);
        } else if (llave > raiz.llave) {
            raiz.derecha = insertarRecursivo(raiz.derecha, llave, contenido, raiz);
        }

        return raiz;
    }
    
    public Nodo buscar(int llave) {
        return buscarRecursivo(raiz, llave);
    }

    private Nodo buscarRecursivo(Nodo nodo, int llave) {
        if (nodo == null) {
            return null;
        }

        if (llave == nodo.llave) {
            return nodo;
        } else if (llave < nodo.llave) {
            return buscarRecursivo(nodo.izquierda, llave);
        } else {
            return buscarRecursivo(nodo.derecha, llave);
        }
    }
    
    //Nota: Para la eliminación se usa el metodo de sustituir con el nodo menor, del lado derecho del nodo a eliminar.
    public void eliminar(int llave) {
        
        if(buscar(llave) == null) {
        
           throw new LlaveInexistenteException("El id "+ llave + " no fue encontrado.");
        }
        raiz = eliminarRec(raiz, llave);
    }
    
    private Nodo eliminarRec(Nodo raizActual, int llave) {
        if (raizActual == null) {
            return raizActual;
        }

        // Recorrer el árbol
        if (llave < raizActual.llave) {
            raizActual.izquierda = eliminarRec(raizActual.izquierda, llave);
        } else if (llave > raizActual.llave) {
            raizActual.derecha = eliminarRec(raizActual.derecha, llave);
        } else {
            // Encontramos el nodo a eliminar

            // Caso 1: Nodo con solo un hijo o sin hijos
            if (raizActual.izquierda == null) {
                return raizActual.derecha;
            } else if (raizActual.derecha == null) {
                return raizActual.izquierda;
            }

            // Caso 2: Nodo con dos hijos
            
            Nodo nodoMenorDerecha = encontrarMinimoRecursivo(raizActual.derecha);
            
            nodoMenorDerecha.padre.izquierda = null;
            
            raizActual.contenido = nodoMenorDerecha.contenido;
            raizActual.llave = nodoMenorDerecha.llave;
        }

        return raizActual;
    }
    
    private Nodo encontrarMinimoRecursivo(Nodo raizActual){
        Nodo siguienteNodo = raizActual.izquierda;
        
        if(siguienteNodo.izquierda!=null){
            siguienteNodo = encontrarMinimoRecursivo(siguienteNodo);
        } else {
            return siguienteNodo;
        }
        
        return siguienteNodo;
    }
    
    public ArrayList<Nodo> recorridoPreOrden() {
        ArrayList<Nodo> resultado = new ArrayList<>();
        recorridoPreOrdenRecursivo(raiz, resultado);
        return resultado;
    }

    private void recorridoPreOrdenRecursivo(Nodo nodo, ArrayList<Nodo> resultado) {
        if (nodo != null) {
            resultado.add(nodo);
            recorridoPreOrdenRecursivo(nodo.izquierda, resultado);
            recorridoPreOrdenRecursivo(nodo.derecha, resultado);
        }
    }
    
    public ArrayList<Nodo> recorridoInOrden() {
        ArrayList<Nodo> resultado = new ArrayList<>();
        recorridoInOrdenRecursivo(raiz, resultado);
        return resultado;
    }

    private void recorridoInOrdenRecursivo(Nodo nodo, ArrayList<Nodo> resultado) {
        if (nodo != null) {
            recorridoInOrdenRecursivo(nodo.izquierda, resultado);
            resultado.add(nodo);
            recorridoInOrdenRecursivo(nodo.derecha, resultado);
        }
    }
    
    public ArrayList<Nodo> recorridoPostOrden() {
        ArrayList<Nodo> resultado = new ArrayList<>();
        recorridoPostOrdenRecursivo(raiz, resultado);
        return resultado;
    }

    private void recorridoPostOrdenRecursivo(Nodo nodo, ArrayList<Nodo> resultado) {
        if (nodo != null) {
            recorridoPostOrdenRecursivo(nodo.izquierda, resultado);
            recorridoPostOrdenRecursivo(nodo.derecha, resultado);
            resultado.add(nodo);
        }
    }
    
    public ArrayList<Nodo> obtenerNodosHoja() {
        ArrayList<Nodo> nodosHoja = new ArrayList<>();
        obtenerNodosHoja(raiz, nodosHoja);
        return nodosHoja;
    }

    private void obtenerNodosHoja(Nodo nodo, ArrayList<Nodo> nodosHoja) {
        if (nodo != null) {
            if (nodo.izquierda == null && nodo.derecha == null) {
                nodosHoja.add(nodo);
            }
            obtenerNodosHoja(nodo.izquierda, nodosHoja);
            obtenerNodosHoja(nodo.derecha, nodosHoja);
        }
    }
}
