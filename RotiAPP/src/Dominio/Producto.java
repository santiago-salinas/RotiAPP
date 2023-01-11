package Dominio;
// Santiago Salinas 266628 / Natalia Vazquez 266986

import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable{
    private String nombre;
    private int precio;
    private final ArrayList<Categoria> listaCategorias;

    public Producto(String nombre, int precio, ArrayList<Categoria> categorias) {
        this.nombre = nombre;
        this.precio = precio;
        this.listaCategorias = categorias;
    }

    public Producto() {
        this.listaCategorias = new ArrayList<>();
    }
    
    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return this.precio;
    }

    public ArrayList<Categoria> getCategorias() {
        return this.listaCategorias;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public void agregarCategoria(Categoria c){
        listaCategorias.add(c);
    }
    
    @Override
    public String toString(){
        return this.getNombre() + " $" +this.getPrecio();
    }

    @Override
    public boolean equals(Object o){
        return this.getNombre().equalsIgnoreCase(((Producto)o).getNombre());
    }
}
