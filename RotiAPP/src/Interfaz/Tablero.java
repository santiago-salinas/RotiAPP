package Interfaz;
// Santiago Salinas 266628 / Natalia Vazquez 266986

import Dominio.Pedido;
import Dominio.Producto;
import Dominio.Rotiseria;
import Exceptions.FalloRegistroException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Tablero extends javax.swing.JFrame implements PropertyChangeListener {

    //Ayuda a la carga de botones
    private boolean inicializado = false;
    private Rotiseria rotiseria;

    public Tablero(Rotiseria rotiseria) {
        initComponents();
        setRotiseria(rotiseria);
        actualizar();
        rotiseria.addPropertyChangeListener(this);

        //Letra "tiene grid layout de 3 filas y 0 columnas"
        pnlInferiorIzquierdo.setLayout(new GridLayout(3, 0));
        //Avisa que ya se inicio
        inicializado = true;

        //Icono
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/icon.png")).getImage());

    }

    public void actualizar() {
        actualizarCombo();
        actualizarLblCliente();
        actualizarBotones();
        actualizarLabelPedido();
        actualizarListaPedido();
    }

    public void actualizarListaPedido() {
        lstPedido.setListData(rotiseria.getPedidoIncompleto().getListaProductos().toArray());
    }

    public void actualizarLblCliente() {
        try {
            lblCliente.setText(getRotiseria().getPedidoIncompleto().getCliente().toString2());
        } catch (Exception e) {
            lblCliente.setText(" Seleccione un cliente");
        }
    }

    public void actualizarCombo() {
        //Recuerda el elemento seleccionado
        var selected = cmboCategorias.getSelectedItem();
        //Borra la lista
        cmboCategorias.removeAllItems();

        //Carga segun el orden seleccionado
        if (rbtnCategAldabetico.isSelected()) {
            getRotiseria().categoriaOrdenAlfabetico();
        } else {
            getRotiseria().categoriaOrdenDecreciente();
        }

        //Agrega los items
        for (int i = 0; i < getRotiseria().getListaCategorias().size(); i++) {
            cmboCategorias.addItem(getRotiseria().getListaCategorias().get(i).toString());
        }

        //Si habia una seleccion previa, la devuelve
        if (selected != null) {
            cmboCategorias.setSelectedItem(selected);
        }
    }

    public void actualizarLabelPedido() {
        int nroPedido = rotiseria.getListaPedidos().size() + 1;
        rotiseria.getPedidoIncompleto().setNumero(nroPedido - 1);
        int total = rotiseria.getPedidoIncompleto().calcularTotal();
        lblPedido.setText("Pedido " + nroPedido + "  $ " + total);
    }

    public void actualizarBotones() {

        pnlInferiorIzquierdo.removeAll();
        for (int i = 0; i < getRotiseria().getListaProductos().size(); i++) {
            Producto producto = getRotiseria().getListaProductos().get(i);
            try {
                for (int j = 0; j < producto.getCategorias().size(); j++) {
                    //Copiado de la Letra
                    if (cmboCategorias.getSelectedItem().equals(producto.getCategorias().get(j).toString())) {
                        JButton nuevo = new JButton(" ");
                        nuevo.setMargin(new Insets(-5, -5, -5, -5));
                        nuevo.setBackground(Color.BLACK);
                        nuevo.setForeground(Color.WHITE);
                        nuevo.setFont(new java.awt.Font("Century Gothic", 0, 12));
                        nuevo.setText(producto.toString());
                        nuevo.addActionListener(new ProductoListener());
                        pnlInferiorIzquierdo.add(nuevo);
                    }

                }
            } catch (Exception e) {

            }
        }

        pnlInferiorIzquierdo.revalidate();
        pnlInferiorIzquierdo.repaint();
    }

    //Copiado de Letra
    private class ProductoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // este código se ejecutará al presionar el botón, obtengo cuál botón
            JButton cual = ((JButton) e.getSource());
            // código a completar según el botón presionado
            rotiseria.getPedidoIncompleto().agregarProducto(getRotiseria().darProductoPorNombre(cual.getText()));
            rotiseria.forcePropertyChange();
        }
    }

    //@Override
    public void propertyChange(PropertyChangeEvent evt) {
        actualizar();
    }

    public Rotiseria getRotiseria() {
        return this.rotiseria;
    }

    public void setRotiseria(Rotiseria rotiseria) {
        this.rotiseria = rotiseria;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpOrden = new javax.swing.ButtonGroup();
        pnlSuperiorIzquierdo = new javax.swing.JPanel();
        btnElegirCliente = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        rbtnCategAldabetico = new javax.swing.JRadioButton();
        rbtnCategPrioridad = new javax.swing.JRadioButton();
        pnlSuperiorDerecho = new javax.swing.JPanel();
        btnClientes = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        pnlMedioIzquierdo = new javax.swing.JPanel();
        cmboCategorias = new javax.swing.JComboBox<>();
        pnlMedioDerecho = new javax.swing.JPanel();
        btnReiniciarPedido = new javax.swing.JButton();
        lblPedido = new javax.swing.JLabel();
        pnlInferiorIzquierdo = new javax.swing.JPanel();
        pnlInferiorDerecho = new javax.swing.JPanel();
        lstProductosPedido = new javax.swing.JScrollPane();
        lstPedido = new javax.swing.JList();
        pnlAcciones = new javax.swing.JPanel();
        btnEliminarItem = new javax.swing.JButton();
        btnGrabarPedido = new javax.swing.JButton();
        mnuSuperior = new javax.swing.JMenuBar();
        menuExportar = new javax.swing.JMenu();
        mnuSaveCSV = new javax.swing.JMenuItem();
        menuInfo = new javax.swing.JMenu();
        mnuInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RotiAPP");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(500, 200));
        setPreferredSize(new java.awt.Dimension(990, 450));
        setSize(new java.awt.Dimension(700, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(3, 2));

        pnlSuperiorIzquierdo.setMinimumSize(new java.awt.Dimension(400, 0));
        pnlSuperiorIzquierdo.setPreferredSize(new java.awt.Dimension(300, 500));
        pnlSuperiorIzquierdo.setLayout(new java.awt.GridLayout(3, 2));

        btnElegirCliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnElegirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/elegircliente.png"))); // NOI18N
        btnElegirCliente.setText("Elegir Cliente");
        btnElegirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirClienteActionPerformed(evt);
            }
        });
        pnlSuperiorIzquierdo.add(btnElegirCliente);

        lblCliente.setBackground(new java.awt.Color(226, 255, 233));
        lblCliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCliente.setText("Ana Garcia (18 de Julio 1234 - 99123123)");
        lblCliente.setOpaque(true);
        pnlSuperiorIzquierdo.add(lblCliente);

        lblObservaciones.setBackground(new java.awt.Color(226, 255, 233));
        lblObservaciones.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblObservaciones.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblObservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/observaciones.png"))); // NOI18N
        lblObservaciones.setText("Observaciones     ");
        lblObservaciones.setOpaque(true);
        pnlSuperiorIzquierdo.add(lblObservaciones);

        txtObservaciones.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtObservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtObservaciones.setPreferredSize(new java.awt.Dimension(5, 20));
        pnlSuperiorIzquierdo.add(txtObservaciones);

        btnGrpOrden.add(rbtnCategAldabetico);
        rbtnCategAldabetico.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        rbtnCategAldabetico.setSelected(true);
        rbtnCategAldabetico.setText("<html>Categorías por<br/>orden Alfabético</html>");
        rbtnCategAldabetico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/abcoff.png"))); // NOI18N
        rbtnCategAldabetico.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/abc.png"))); // NOI18N
        rbtnCategAldabetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCategAldabeticoActionPerformed(evt);
            }
        });
        pnlSuperiorIzquierdo.add(rbtnCategAldabetico);

        btnGrpOrden.add(rbtnCategPrioridad);
        rbtnCategPrioridad.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        rbtnCategPrioridad.setText("<html>Categorías por<br/>orden de Prioridad</html>");
        rbtnCategPrioridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/1234off.png"))); // NOI18N
        rbtnCategPrioridad.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/1234.png"))); // NOI18N
        rbtnCategPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCategPrioridadActionPerformed(evt);
            }
        });
        pnlSuperiorIzquierdo.add(rbtnCategPrioridad);

        getContentPane().add(pnlSuperiorIzquierdo);

        pnlSuperiorDerecho.setMinimumSize(new java.awt.Dimension(600, 0));
        pnlSuperiorDerecho.setPreferredSize(new java.awt.Dimension(800, 67));
        pnlSuperiorDerecho.setLayout(new java.awt.GridLayout(1, 4));

        btnClientes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        pnlSuperiorDerecho.add(btnClientes);

        btnCategorias.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/categorias.png"))); // NOI18N
        btnCategorias.setText("Categorías");
        btnCategorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCategorias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });
        pnlSuperiorDerecho.add(btnCategorias);

        btnProductos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/productos.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        pnlSuperiorDerecho.add(btnProductos);

        btnPedidos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/pedidos.png"))); // NOI18N
        btnPedidos.setText("<html><center>Ver<br/>Pedidos</center></html>");
        btnPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });
        pnlSuperiorDerecho.add(btnPedidos);

        getContentPane().add(pnlSuperiorDerecho);

        pnlMedioIzquierdo.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlMedioIzquierdo.setLayout(new java.awt.GridLayout(1, 0));

        cmboCategorias.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        cmboCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboCategoriasItemStateChanged(evt);
            }
        });
        pnlMedioIzquierdo.add(cmboCategorias);

        getContentPane().add(pnlMedioIzquierdo);

        pnlMedioDerecho.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlMedioDerecho.setLayout(new java.awt.GridLayout(2, 1));

        btnReiniciarPedido.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnReiniciarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/reinicio.png"))); // NOI18N
        btnReiniciarPedido.setText("Reiniciar Pedido");
        btnReiniciarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarPedidoActionPerformed(evt);
            }
        });
        pnlMedioDerecho.add(btnReiniciarPedido);

        lblPedido.setBackground(new java.awt.Color(226, 255, 233));
        lblPedido.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPedido.setText("Pedido 1 $470");
        lblPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPedido.setOpaque(true);
        pnlMedioDerecho.add(lblPedido);

        getContentPane().add(pnlMedioDerecho);

        javax.swing.GroupLayout pnlInferiorIzquierdoLayout = new javax.swing.GroupLayout(pnlInferiorIzquierdo);
        pnlInferiorIzquierdo.setLayout(pnlInferiorIzquierdoLayout);
        pnlInferiorIzquierdoLayout.setHorizontalGroup(
            pnlInferiorIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        pnlInferiorIzquierdoLayout.setVerticalGroup(
            pnlInferiorIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );

        getContentPane().add(pnlInferiorIzquierdo);

        pnlInferiorDerecho.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlInferiorDerecho.setPreferredSize(new java.awt.Dimension(300, 131));
        pnlInferiorDerecho.setLayout(new java.awt.GridLayout(1, 0));

        lstPedido.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lstProductosPedido.setViewportView(lstPedido);

        pnlInferiorDerecho.add(lstProductosPedido);

        pnlAcciones.setLayout(new java.awt.GridLayout(1, 0));

        btnEliminarItem.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminarItem.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnEliminarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/eliminar.png"))); // NOI18N
        btnEliminarItem.setText("<html><center>Eliminar<br/>Item/s</center></html>");
        btnEliminarItem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEliminarItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarItemActionPerformed(evt);
            }
        });
        pnlAcciones.add(btnEliminarItem);

        btnGrabarPedido.setBackground(new java.awt.Color(204, 255, 204));
        btnGrabarPedido.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnGrabarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/ok.png"))); // NOI18N
        btnGrabarPedido.setText("<html><center>Grabar<br/>Pedido</center></html>");
        btnGrabarPedido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGrabarPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGrabarPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGrabarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarPedidoActionPerformed(evt);
            }
        });
        pnlAcciones.add(btnGrabarPedido);

        pnlInferiorDerecho.add(pnlAcciones);

        getContentPane().add(pnlInferiorDerecho);

        menuExportar.setText("Exportar");

        mnuSaveCSV.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuSaveCSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/exportar.png"))); // NOI18N
        mnuSaveCSV.setText("Exportar CSV");
        mnuSaveCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveCSVActionPerformed(evt);
            }
        });
        menuExportar.add(mnuSaveCSV);

        mnuSuperior.add(menuExportar);

        menuInfo.setText("Info");

        mnuInfo.setText("Info");
        mnuInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInfoActionPerformed(evt);
            }
        });
        menuInfo.add(mnuInfo);

        mnuSuperior.add(menuInfo);

        setJMenuBar(mnuSuperior);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnElegirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirClienteActionPerformed
        ElegirCliente ventana = new ElegirCliente(getRotiseria());
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnElegirClienteActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        Clientes ventana = new Clientes(getRotiseria());
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        Categorias ventana = new Categorias(getRotiseria());
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        Productos ventana = new Productos(getRotiseria());
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        Pedidos ventana = new Pedidos(getRotiseria());
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void cmboCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboCategoriasItemStateChanged
        //Detecta que se cambio la seleccion
        //El inicializado evita un loop infinito cuando se initComponents();
        if (inicializado) {
            actualizarBotones();
        }
    }//GEN-LAST:event_cmboCategoriasItemStateChanged

    private void rbtnCategPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCategPrioridadActionPerformed
        actualizar();
    }//GEN-LAST:event_rbtnCategPrioridadActionPerformed

    private void rbtnCategAldabeticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCategAldabeticoActionPerformed
        actualizar();
    }//GEN-LAST:event_rbtnCategAldabeticoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int reply = JOptionPane.showConfirmDialog(null, "¿Desea Guardar?", "Antes de cerrar", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                FileOutputStream file = new FileOutputStream("archivo");
                BufferedOutputStream b = new BufferedOutputStream(file);
                ObjectOutputStream o = new ObjectOutputStream(b);

                o.writeObject(rotiseria);
                o.flush();
                o.close();
            } catch (FileNotFoundException e) {

            } catch (IOException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Se ha guardado el progreso", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha guardado el progreso", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnGrabarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarPedidoActionPerformed
        Pedido pedidoCompleto = rotiseria.getPedidoIncompleto();
        pedidoCompleto.setObservaciones(txtObservaciones.getText());
        try {
            this.rotiseria.agregarPedido(pedidoCompleto);
            rotiseria.resetPedidoIncompleto();
            txtObservaciones.setText("");
            rotiseria.forcePropertyChange();
            JOptionPane.showMessageDialog(this, "Se ha grabado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (FalloRegistroException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGrabarPedidoActionPerformed

    private void btnEliminarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarItemActionPerformed
        lstPedido.getSelectedIndices();
        Producto[] elementosborrar = new Producto[lstPedido.getSelectedValuesList().size()];
        for (int i = 0; i < lstPedido.getSelectedValuesList().size(); i++) {
            elementosborrar[i] = rotiseria.getPedidoIncompleto().getListaProductos().get(lstPedido.getSelectedIndices()[i]);
        }
        for (int i = 0; i < elementosborrar.length; i++) {
            rotiseria.getPedidoIncompleto().getListaProductos().remove(elementosborrar[i]);
        }
        rotiseria.forcePropertyChange();
    }//GEN-LAST:event_btnEliminarItemActionPerformed

    private void btnReiniciarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarPedidoActionPerformed
        rotiseria.resetPedidoIncompleto();
        txtObservaciones.setText("");
        rotiseria.forcePropertyChange();
    }//GEN-LAST:event_btnReiniciarPedidoActionPerformed

    private void mnuSaveCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveCSVActionPerformed
        String fileName = "";
        final JFileChooser fc = new JFileChooser();
        int response = fc.showSaveDialog(Tablero.this);
        if (response == JFileChooser.APPROVE_OPTION) {
            fileName = fc.getSelectedFile().toString();
        } else {
            fileName = "";
        }

        if (!fileName.equals("")) {
            try {
                getRotiseria().guardarCSV(fileName);
                Tablero tablero = new Tablero(getRotiseria());
                tablero.setVisible(true);
                this.setVisible(false);
            } catch (FalloRegistroException ex) {

            }
        }
    }//GEN-LAST:event_mnuSaveCSVActionPerformed

    private void mnuInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInfoActionPerformed
        Info ventana = new Info();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(this);
    }//GEN-LAST:event_mnuInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnElegirCliente;
    private javax.swing.JButton btnEliminarItem;
    private javax.swing.JButton btnGrabarPedido;
    private javax.swing.ButtonGroup btnGrpOrden;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnReiniciarPedido;
    private javax.swing.JComboBox<String> cmboCategorias;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JList lstPedido;
    private javax.swing.JScrollPane lstProductosPedido;
    private javax.swing.JMenu menuExportar;
    private javax.swing.JMenu menuInfo;
    private javax.swing.JMenuItem mnuInfo;
    private javax.swing.JMenuItem mnuSaveCSV;
    private javax.swing.JMenuBar mnuSuperior;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlInferiorDerecho;
    private javax.swing.JPanel pnlInferiorIzquierdo;
    private javax.swing.JPanel pnlMedioDerecho;
    private javax.swing.JPanel pnlMedioIzquierdo;
    private javax.swing.JPanel pnlSuperiorDerecho;
    private javax.swing.JPanel pnlSuperiorIzquierdo;
    private javax.swing.JRadioButton rbtnCategAldabetico;
    private javax.swing.JRadioButton rbtnCategPrioridad;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables

}
