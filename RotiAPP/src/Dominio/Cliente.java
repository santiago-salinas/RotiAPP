package Dominio;
// Santiago Salinas 266628 / Natalia Vazquez 266986

import java.io.Serializable;

public class Cliente implements Serializable{
    private String nombre;
    private String direccion;
    private int telefono;
    
    public Cliente(String nombre, String direccion, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    

    //toString
    @Override
    public String toString(){
        return this.getNombre() + " (" 
                + this.getDireccion() + " - " + this.getTelefono() + " )";
    }
    
    //Agrega sintaxis para salto de linea
    public String toString2(){
        return "<html>"+this.getNombre() + "<br/>(" 
                + this.getDireccion() + " - " + this.getTelefono() + " )</html>";
        //<html>Ver<br/>pedidos</html>
    }
    
    //Equals
    @Override
    public boolean equals(Object o){
        return this.getNombre().equalsIgnoreCase(((Cliente)o).getNombre());
    }
}
