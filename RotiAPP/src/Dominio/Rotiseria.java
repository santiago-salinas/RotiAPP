package Dominio;
// Santiago Salinas 266628 / Natalia Vazquez 266986

import Archivo.ArchivoGrabacion;
import Archivo.ArchivoLectura;
import Exceptions.FalloRegistroException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Rotiseria implements Serializable {

    private static final long serialVersionUID = 123456789;
    private transient PropertyChangeSupport gestor;
    private Pedido pedidoIncompleto = new Pedido();
    private final ArrayList<Cliente> listaClientes;
    private final ArrayList<Categoria> listaCategorias;
    private final ArrayList<Producto> listaProductos;
    private final ArrayList<Pedido> listaPedidos;

    public Rotiseria() {
        listaClientes = new ArrayList<>();
        listaCategorias = new ArrayList<>();
        listaProductos = new ArrayList<>();
        listaPedidos = new ArrayList<>();
        pedidoIncompleto = new Pedido();
        newGestor();
    }

    //Como es transient, preciso poder agregarlo despues de recuperado
    public void newGestor() {
        gestor = new PropertyChangeSupport(this);
    }

    public Pedido getPedidoIncompleto() {
        return this.pedidoIncompleto;
    }

    public void resetPedidoIncompleto() {
        pedidoIncompleto = new Pedido();
    }

    public void forcePropertyChange() {
        gestor.firePropertyChange("", null, new Pedido());
    }

    public ArrayList<Cliente> getListaClientes() {
        return this.listaClientes;
    }

    public ArrayList<Categoria> getListaCategorias() {
        return this.listaCategorias;
    }

    public ArrayList<Producto> getListaProductos() {
        return this.listaProductos;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return this.listaPedidos;
    }

    public void addPropertyChangeListener(PropertyChangeListener lis) {
        gestor.addPropertyChangeListener(lis);
    }

    public void chequearVacio(String a, String b, int c) throws FalloRegistroException {
        if (a.equals("") || b.equals("") || c <= 0) {
            throw new FalloRegistroException("No se pudo agregar, faltan datos o son incorrectos");
        }
    }

    public void chequearPreviamenteUsado(Object[] array, Object obj) throws FalloRegistroException {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(obj)) {
                throw new FalloRegistroException("No se pudo agregar, ya se ecunentra en memoria");
            }
        }
    }

    public void agregarCliente(Cliente cliente) throws FalloRegistroException {
        chequearVacio(cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono());
        chequearPreviamenteUsado(getListaClientes().toArray(), cliente);
        getListaClientes().add(cliente);
        forcePropertyChange();
    }

    public void agregarCategoria(Categoria categoria) throws FalloRegistroException {
        chequearVacio(categoria.getDescripcion(), categoria.getDetalles(), 1);
        chequearPreviamenteUsado(getListaCategorias().toArray(), categoria);
        getListaCategorias().add(categoria);
        forcePropertyChange();
    }

    public void agregarProducto(Producto producto) throws FalloRegistroException {
        chequearVacio(producto.getNombre(), producto.getCategorias().toString(), producto.getPrecio());
        chequearPreviamenteUsado(getListaProductos().toArray(), producto);
        if(producto.getListaCategorias().size()==0){
            throw new FalloRegistroException("Debe Seleccionar al menos una categoria");
        }
        getListaProductos().add(producto);
        forcePropertyChange();
    }

    public void agregarPedido(Pedido pedido) throws FalloRegistroException {
        if (pedido.getCliente() == null) {
            throw new FalloRegistroException("Debe Seleccionar un cliente");
        }
        if (pedido.getListaProductos().isEmpty()) {
            throw new FalloRegistroException("Debe haber al menos un producto");
        }
        getListaPedidos().add(pedido);
        forcePropertyChange();
    }

    public ArrayList<Categoria> categoriaOrdenAlfabetico() {
        Collections.sort(listaCategorias, new Comparator<Categoria>() {
            @Override
            public int compare(Categoria c1, Categoria c2) {
                return c1.getDescripcion().compareTo(c2.getDescripcion());
            }
        });
        return listaCategorias;
    }

    public ArrayList<Categoria> categoriaOrdenDecreciente() {
        Collections.sort(listaCategorias, new Comparator<Categoria>() {
            @Override
            public int compare(Categoria c1, Categoria c2) {
                return c1.getPrioridad() - c2.getPrioridad();
            }
        });
        return listaCategorias;
    }

    public ArrayList<Cliente> darClientesPorNombre(String input) {
        ArrayList<Cliente> listaRetornar = new ArrayList<Cliente>();
        ArrayList<Cliente> lista = this.getListaClientes();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().toLowerCase().contains(input.toLowerCase())) {
                listaRetornar.add(lista.get(i));
            }
        }

        return listaRetornar;
    }

    public Categoria darCategoriaPorNombre(String name) {
        Categoria retornar = new Categoria();

        for (int i = 0; i < getListaCategorias().size(); i++) {
            if (getListaCategorias().get(i).getDescripcion().equals(name)) {
                retornar = getListaCategorias().get(i);
            }
        }

        return retornar;
    }

    public Producto darProductoPorNombre(String name) {
        Producto retornar = new Producto();

        for (int i = 0; i < getListaProductos().size(); i++) {
            if (getListaProductos().get(i).toString().equals(name)) {
                retornar = getListaProductos().get(i);
            }
        }
        return retornar;
    }
    
    public void cargarCSV(String fileName) throws FalloRegistroException {
        
        ArchivoLectura al = new ArchivoLectura(fileName);
        al.hayMasLineas();
        char compare = ' ';
        
        //Detecta si la separacion es por "," o por ";"
        if (al.linea().contains(";")) {
            compare = ';';
        } else {
            compare = ',';
        }
        
        //Elimina caracteres y espacios, dejando el numero
        //Clientes
        int cantClientes = (Integer.parseInt(al.linea().replace(compare, ' ').trim()));
        for (int i = 0; i < cantClientes; i++) {
            al.hayMasLineas();
            String[] datos = al.linea().split(""+compare);
            agregarCliente(new Cliente(datos[0], datos[1], Integer.parseInt(datos[2])));
        }
        //Categorias
        al.hayMasLineas();
        int cantCategorias = (Integer.parseInt(al.linea().replace(compare, ' ').trim()));
        for (int i = 0; i < cantCategorias; i++) {
            al.hayMasLineas();
            String[] datos = al.linea().split(""+compare);
            agregarCategoria(new Categoria(datos[0], datos[1], Integer.parseInt(datos[2])));
        }
        //Productos
        al.hayMasLineas();
        int cantProductos = (Integer.parseInt(al.linea().replace(compare, ' ').trim()));
        for (int i = 0; i < cantProductos; i++) {
            al.hayMasLineas();
            String[] datos = al.linea().split(""+compare);
            ArrayList<Categoria> categorias = new ArrayList();
            for (int j = 2; j < datos.length; j++) {
                categorias.add(darCategoriaPorNombre(datos[j]));
            }
            agregarProducto(new Producto(datos[0], Integer.parseInt(datos[1]), categorias));
        }
        al.cerrar();
    }

    public void guardarCSV(String fileName) throws FalloRegistroException {
        if (!(fileName.contains(".csv"))) {
            fileName += ".csv";
        }

        ArchivoGrabacion ag = new ArchivoGrabacion(fileName);
        ag.grabarLinea(getListaClientes().size() + ",,,");
        for (int i = 0; i < getListaClientes().size(); i++) {
            Cliente cliente = getListaClientes().get(i);
            ag.grabarLinea(cliente.getNombre() + "," + cliente.getDireccion() + "," + cliente.getTelefono() + ",");
        }
        ag.grabarLinea(getListaCategorias().size() + ",,,");
        for (int i = 0; i < getListaCategorias().size(); i++) {
            Categoria categoria = getListaCategorias().get(i);
            ag.grabarLinea(categoria.getDescripcion() + "," + categoria.getDetalles() + "," + categoria.getPrioridad() + ",");
        }
        ag.grabarLinea(getListaProductos().size() + ",,,");
        for (int i = 0; i < getListaProductos().size(); i++) {
            String linea = getListaProductos().get(i).getNombre() + "," + getListaProductos().get(i).getPrecio() + ",";
            for (int j = 0; j < getListaProductos().get(i).getCategorias().size(); j++) {
                linea += getListaProductos().get(i).getCategorias().get(j) + ",";
            }
            ag.grabarLinea(linea);
        }
        ag.cerrar();
    }
}
