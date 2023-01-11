package Interfaz;
// Santiago Salinas 266628 / Natalia Vazquez 266986


import Dominio.Categoria;
import Dominio.Rotiseria;
import Exceptions.FalloRegistroException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Categorias extends javax.swing.JFrame {

    public Rotiseria rotiseria;

    public Categorias() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public Categorias(Rotiseria rotiseria) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setRotiseria(rotiseria);
    }

    public void setRotiseria(Rotiseria rotiseria) {
        this.rotiseria = rotiseria;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCategorias = new javax.swing.JLabel();
        linea = new javax.swing.JSeparator();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblPrioridad = new javax.swing.JLabel();
        lblDetalles = new javax.swing.JLabel();
        txtDetalles = new javax.swing.JTextField();
        btnAlta = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        comboPrioridad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(500, 292));

        lblCategorias.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategorias.setText("Categorías");

        lblDescripcion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDescripcion.setText("Descripción");

        txtDescripcion.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        lblPrioridad.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPrioridad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrioridad.setText("Prioridad");

        lblDetalles.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblDetalles.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDetalles.setText("Detalles");

        txtDetalles.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        btnAlta.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnAlta.setText("Dar Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        comboPrioridad.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        comboPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(linea)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(80, 80, 80))
                    .addComponent(txtDescripcion)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPrioridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(100, 100, 100))
                    .addComponent(txtDetalles)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(106, 106, 106))
                    .addComponent(comboPrioridad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addComponent(btnAlta, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(70, 70, 70)
                .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linea, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(lblPrioridad, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboPrioridad)
                                .addGap(28, 28, 28)
                                .addComponent(lblDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addGap(31, 31, 31))
                            .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(84, 84, 84))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        String descripcion = txtDescripcion.getText();
        String detalles = txtDetalles.getText();
        int prioridad = Integer.parseInt(comboPrioridad.getSelectedItem().toString());
        Categoria categoria = new Categoria(descripcion, detalles, prioridad);

        try {
            this.rotiseria.agregarCategoria(categoria);
            txtDescripcion.setText("");
            txtDetalles.setText("");
            comboPrioridad.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, "Se ha ingresado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (FalloRegistroException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAltaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JComboBox<String> comboPrioridad;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel lblCategorias;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JLabel lblPrioridad;
    private javax.swing.JSeparator linea;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDetalles;
    // End of variables declaration//GEN-END:variables
}
