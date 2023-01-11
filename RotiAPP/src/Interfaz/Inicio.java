package Interfaz;
// Santiago Salinas 266628 / Natalia Vazquez 266986

import Dominio.Rotiseria;
import Exceptions.FalloRegistroException;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Inicio extends javax.swing.JFrame {

    private Rotiseria rotiseria;
    private boolean continuar;

    public Inicio(Rotiseria rotiseria, boolean continuar) throws IOException, ClassNotFoundException {
        initComponents();
        setRotiseria(rotiseria);
        setContinuar(continuar);
        //Para eliminar ojbeto al cerrar ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Icono superior izquierdo
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/icon.png")).getImage());
        //Si no esta la persistrencia, se anula la opcion
        if (!getContinuar()) {
            btnContinuarPersistencia.setBackground(Color.LIGHT_GRAY);
            btnEliminarPersistencia.setVisible(false);
        }
    }

    public void setRotiseria(Rotiseria rotiseria) {
        this.rotiseria = rotiseria;
    }

    public Rotiseria getRotiseria() {
        return this.rotiseria;
    }

    public void setContinuar(boolean continuar) {
        this.continuar = continuar;
    }

    public boolean getContinuar() {
        return this.continuar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        linea = new javax.swing.JSeparator();
        lblClientes = new javax.swing.JLabel();
        btnCargarCSV = new javax.swing.JButton();
        btnSistemaVacio = new javax.swing.JButton();
        btnContinuarPersistencia = new javax.swing.JButton();
        btnEliminarPersistencia = new javax.swing.JButton();
        imgLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(370, 303));

        lblClientes.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClientes.setText("Bienvenido!");

        btnCargarCSV.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnCargarCSV.setText("Cargar Datos de Prueba");
        btnCargarCSV.setMinimumSize(new java.awt.Dimension(160, 22));
        btnCargarCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarCSVActionPerformed(evt);
            }
        });

        btnSistemaVacio.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnSistemaVacio.setText("Sistema Vacio");
        btnSistemaVacio.setMaximumSize(new java.awt.Dimension(160, 22));
        btnSistemaVacio.setMinimumSize(new java.awt.Dimension(160, 22));
        btnSistemaVacio.setPreferredSize(new java.awt.Dimension(160, 22));
        btnSistemaVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSistemaVacioActionPerformed(evt);
            }
        });

        btnContinuarPersistencia.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnContinuarPersistencia.setText("Continuar donde se dejo");
        btnContinuarPersistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarPersistenciaActionPerformed(evt);
            }
        });

        btnEliminarPersistencia.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnEliminarPersistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/eliminarchico.png"))); // NOI18N
        btnEliminarPersistencia.setText("Borrar datos guardados");
        btnEliminarPersistencia.setToolTipText("Borrar persistencia");
        btnEliminarPersistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPersistenciaActionPerformed(evt);
            }
        });

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/img/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(linea)
            .addComponent(lblClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnContinuarPersistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCargarCSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarPersistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSistemaVacio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(imgLogo)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linea, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSistemaVacio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(btnCargarCSV, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnContinuarPersistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(btnEliminarPersistencia))
                    .addComponent(imgLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarPersistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarPersistenciaActionPerformed
        if (getContinuar()) {
            Tablero tablero = new Tablero(getRotiseria());
            tablero.setVisible(true);
            this.setVisible(false);
            tablero.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(this, "No se tiene persistencia en memoria", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnContinuarPersistenciaActionPerformed

    private void btnSistemaVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSistemaVacioActionPerformed
        Tablero tablero = new Tablero(new Rotiseria());
        tablero.setVisible(true);
        this.setVisible(false);
        tablero.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSistemaVacioActionPerformed

    //https://www.youtube.com/watch?v=XXkq73u9Uqg
    private void btnCargarCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarCSVActionPerformed
        String fileName = "";
        final JFileChooser fc = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("csv", "csv");
        fc.setFileFilter(filter);
        int response = fc.showOpenDialog(Inicio.this);
        if (response == JFileChooser.APPROVE_OPTION) {
            fileName = fc.getSelectedFile().toString();
        } else {
            fileName = "";
        }

        if (!fileName.equals("")) {
            try {
                this.rotiseria = new Rotiseria();
                getRotiseria().cargarCSV(fileName);
                Tablero tablero = new Tablero(getRotiseria());
                tablero.setVisible(true);
                tablero.setLocationRelativeTo(null);
                this.setVisible(false);
            } catch (FalloRegistroException ex) {
                JOptionPane.showMessageDialog(this, "Archivo Dañado", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Archivo Dañado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCargarCSVActionPerformed

    private void btnEliminarPersistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPersistenciaActionPerformed
        File myObj = new File("archivo");
        myObj.delete();
        btnContinuarPersistencia.setBackground(Color.gray);
        this.continuar = false;
        btnEliminarPersistencia.setVisible(false);
    }//GEN-LAST:event_btnEliminarPersistenciaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarCSV;
    private javax.swing.JButton btnContinuarPersistencia;
    private javax.swing.JButton btnEliminarPersistencia;
    private javax.swing.JButton btnSistemaVacio;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JSeparator linea;
    // End of variables declaration//GEN-END:variables
}
