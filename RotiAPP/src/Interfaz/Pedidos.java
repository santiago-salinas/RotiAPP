package Interfaz;
// Santiago Salinas 266628 / Natalia Vazquez 266986

import Dominio.Pedido;
import Dominio.Rotiseria;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Pedidos extends javax.swing.JFrame {

    private Rotiseria rotiseria;

    public void setRotiseria(Rotiseria rotiseria) {
        this.rotiseria = rotiseria;
    }
    
    public Rotiseria getRotiseria() {
        return this.rotiseria;
    }
    
    public Pedidos(Rotiseria rotiseria) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setRotiseria(rotiseria);
        if (!getRotiseria().getListaPedidos().isEmpty()){
            cargar();
        }
        
    }
    
    private void cargar(){
        lstPedidos.setListData(getRotiseria().getListaPedidos().toArray());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVerPedidos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblPedidos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPedidos = new javax.swing.JList();
        lblTotal = new javax.swing.JLabel();
        lblTotal$ = new javax.swing.JLabel();
        lblProductos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProductos = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        lblObservaciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(716, 314));

        lblVerPedidos.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblVerPedidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVerPedidos.setText("Ver Pedidos");

        lblPedidos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPedidos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPedidos.setText("Pedidos");

        lstPedidos.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lstPedidos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "No hay pedidos" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstPedidos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPedidosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPedidos);

        lblTotal.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal.setText("Total");

        lblTotal$.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblTotal$.setText("$ 0");

        lblProductos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProductos.setText("Productos");

        lstProductos.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        lstProductos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Seleccione un pedido" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstProductos);

        txaObservaciones.setEditable(false);
        txaObservaciones.setColumns(20);
        txaObservaciones.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txaObservaciones.setLineWrap(true);
        txaObservaciones.setRows(5);
        txaObservaciones.setAutoscrolls(false);
        jScrollPane3.setViewportView(txaObservaciones);

        lblObservaciones.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblObservaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblObservaciones.setText("Observaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGap(106, 106, 106))
                    .addComponent(jScrollPane1))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(lblTotal)
                            .addGap(18, 18, 18)
                            .addComponent(lblTotal$, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVerPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVerPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 4, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(lblTotal$, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstPedidosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPedidosValueChanged
        if (!getRotiseria().getListaPedidos().isEmpty()){
            ArrayList<Pedido> pedidos = getRotiseria().getListaPedidos();
            int pos = lstPedidos.getSelectedIndex();
            Pedido p = pedidos.get(pos);
            lstProductos.setListData(p.getListaProductos().toArray());
            int total = p.getTotal();
            lblTotal$.setText("$ " + total);
            txaObservaciones.setText(p.getObservaciones());
        }
    }//GEN-LAST:event_lstPedidosValueChanged
/**/


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPedidos;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotal$;
    private javax.swing.JLabel lblVerPedidos;
    private javax.swing.JList lstPedidos;
    private javax.swing.JList lstProductos;
    private javax.swing.JTextArea txaObservaciones;
    // End of variables declaration//GEN-END:variables
}
