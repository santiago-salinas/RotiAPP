package Dominio;
// Santiago Salinas 266628 / Natalia Vazquez 266986

import java.io.Serializable;

public class Categoria implements Serializable{
    private String descripcion;
    private String detalles;
    private int prioridad;

    public Categoria(){
    
    }
    
    public Categoria(String descripcion,String detalles, int prioridad) {
        setDescripcion(descripcion);
        setPrioridad(prioridad);
        setDetalles(detalles);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    

    //toString
    @Override
    public String toString(){
        return getDescripcion();
    }
    
    @Override
    public boolean equals(Object o){
        return ((Categoria)o).getDescripcion().equals(this.getDescripcion());
    }
}
