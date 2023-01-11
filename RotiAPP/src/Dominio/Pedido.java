package Dominio;
// Santiago Salinas 266628 / Natalia Vazquez 266986

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
    private Cliente cliente;
    private final ArrayList<Producto> listaProductos;
    private int numero;
    private int total;
    private String observaciones;

    public Pedido() {
        this.cliente = null;
        this.numero = 0;
        this.total = 0;
        this.listaProductos = new ArrayList();
    }

    public Pedido(Cliente cliente, int numero, int total) {
        this.cliente = cliente;
        this.numero = numero;
        this.total = total;
        this.listaProductos = new ArrayList();
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public ArrayList<Producto> getListaProductos() {
        return this.listaProductos;
    }

    public int getNumero() {
        return this.numero;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
        
    public int calcularTotal(){
        ArrayList<Producto> prod = this.getListaProductos();
        int tot = 0;
        for(Producto p : prod){
            tot += p.getPrecio();
        }
        this.total = tot;
        return getTotal();
    }
    
    //Agrega un producto y recalcula el total
    public void agregarProducto(Producto p){
        listaProductos.add(p);
        this.calcularTotal();
    }
    
    //Elimina un producto y recalcula el total
    public void eliminarProducto(Producto p){
        listaProductos.remove(p);
        this.calcularTotal();
    }
    
    //toString
    @Override
    public String toString(){
        //String retorno = 
        
        return this.getNumero() + "- " + this.getCliente().getNombre();
    }
}
