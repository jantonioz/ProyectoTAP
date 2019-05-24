/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tap_test;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author josea
 */
public class Status extends javax.swing.JFrame implements Runnable {

    int cantRayos = 200;
    Color mColor;
    boolean fadingColors = false;
    Thread t;
    boolean hayCambios = false;
    Dimension dim;

    public Status() {
        initComponents();
        mColor = new Color(255, 255, 255);
        t = new Thread(this);
        jTextField1.setText(1280 + "");
        jTextField2.setText(720 + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblDisplayFps = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSliderRayos = new javax.swing.JSlider();
        labelRayos = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSliderRojo = new javax.swing.JSlider();
        jSliderVerde = new javax.swing.JSlider();
        jSliderAzul = new javax.swing.JSlider();
        jcbFading = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("FPS:");

        lblDisplayFps.setBackground(new java.awt.Color(153, 153, 153));
        lblDisplayFps.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lblDisplayFps.setForeground(new java.awt.Color(255, 233, 19));
        lblDisplayFps.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisplayFps.setText("0");
        lblDisplayFps.setOpaque(true);

        jLabel2.setText("No. Rayos:");

        jSliderRayos.setMaximum(360);
        jSliderRayos.setValue(200);
        jSliderRayos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderRayosStateChanged(evt);
            }
        });

        labelRayos.setText("200");

        jLabel4.setText("Rojo");

        jLabel5.setText("Verde");

        jLabel6.setText("Azul");

        jSliderRojo.setMaximum(255);
        jSliderRojo.setValue(255);
        jSliderRojo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderRojoStateChanged(evt);
            }
        });

        jSliderVerde.setMaximum(255);
        jSliderVerde.setValue(255);
        jSliderVerde.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderVerdeStateChanged(evt);
            }
        });

        jSliderAzul.setMaximum(255);
        jSliderAzul.setValue(255);
        jSliderAzul.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderAzulStateChanged(evt);
            }
        });

        jcbFading.setText("Fading colors");
        jcbFading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFadingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSliderRojo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSliderVerde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSliderAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbFading)
                .addGap(157, 157, 157))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSliderRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSliderVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSliderAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbFading)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Tamaño de ventana:");

        jLabel8.setText("X");

        jButton1.setText("Establecer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblDisplayFps, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jSliderRayos, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)
                        .addComponent(labelRayos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDisplayFps))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelRayos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSliderRayos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSliderRayosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderRayosStateChanged
        cantRayos = jSliderRayos.getValue();
        labelRayos.setText(String.valueOf(cantRayos));
    }//GEN-LAST:event_jSliderRayosStateChanged

    private void jSliderRojoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderRojoStateChanged
        mColor = new Color(jSliderRojo.getValue(), jSliderVerde.getValue(), jSliderAzul.getValue());
        //hayCambios = true;
    }//GEN-LAST:event_jSliderRojoStateChanged

    private void jSliderVerdeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderVerdeStateChanged
        mColor = new Color(jSliderRojo.getValue(), jSliderVerde.getValue(), jSliderAzul.getValue());
        //hayCambios = true;
    }//GEN-LAST:event_jSliderVerdeStateChanged

    private void jSliderAzulStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderAzulStateChanged
        mColor = new Color(jSliderRojo.getValue(), jSliderVerde.getValue(), jSliderAzul.getValue());
        //hayCambios = true;
    }//GEN-LAST:event_jSliderAzulStateChanged

    /**
     * Activa el desplazamiento de colores con un hilo nuevo
     * @param evt 
     */
    private void jcbFadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFadingActionPerformed
        if (jcbFading.isSelected()) {
            t = new Thread(this);
            t.start();
            //hayCambios = true;
        } else if (!jcbFading.isSelected()) {
            t.interrupt();
        }
    }//GEN-LAST:event_jcbFadingActionPerformed
    /**
     * Activa el cambio de configuracion del juego
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()) {
            return;
        }
        dim = new Dimension(Integer.parseInt(jTextField1.getText()), Integer.parseInt(jTextField2.getText()));
        hayCambios = true;
        System.out.println("CAMBIO DE TAMAÑO");
    }//GEN-LAST:event_jButton1ActionPerformed

    public void setFps(int fps) {
        this.lblDisplayFps.setText("" + fps);
    }

    public int getCantRayos() {
        return cantRayos;
    }

    public void setCantRayos(int cantRayos) {
        this.cantRayos = cantRayos;
    }

    public Color getColor() {
        return new Color(jSliderRojo.getValue(), jSliderVerde.getValue(), jSliderAzul.getValue());
    }

    public void setColor(Color mColor) {
        this.mColor = mColor;
    }

    public boolean isFadingColors() {
        return fadingColors;
    }

    public void setFadingColors(boolean fadingColors) {
        this.fadingColors = fadingColors;
    }

    public boolean isHayCambios() {
        return hayCambios;
    }

    public void setHayCambios(boolean hayCambios) {
        this.hayCambios = hayCambios;
    }

    public Dimension getDim() {
        if (dim == null) {
            return null;
        }
        return new Dimension(dim.width, dim.height);
    }

    public void setDim(Dimension dimension) {
        this.dim = new Dimension(dimension.width, dimension.height);
    }

    /**
     * Ejecuta el algoritmo de fading colors 
     */
    @Override
    public void run() {
        int r = 255, g = 0, b = 0, incR = 0, incG = 0, incB = 0;
        while (jcbFading.isSelected()) {

            r += incR;
            g += incG;
            b += incB;

            if (r == 255 && g == 0 && b == 0) {
                incB = 0;
                incG = 5;
            }
            if (r == 255 && g == 255 && b == 0) {
                incG = 0;
                incR = -5;
            }
            if (r == 0 && g == 255 && b == 0) {
                incR = 0;
                incB = 5;
            }
            if (r == 0 && g == 255 && b == 255) {
                incB = 0;
                incG = -5;
            }
            if (r == 0 && g == 0 && b == 255) {
                incG = 0;
                incR = 5;
            }
            if (r == 255 && g == 0 && b == 255) {
                incR = 0;
                incB = -5;
            }

            jSliderRojo.setValue(r);
            jSliderVerde.setValue(g);
            jSliderAzul.setValue(b);
            //hayCambios = true;
            try {
                Thread.sleep(16);
            } catch (InterruptedException ex) {

            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Status().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSliderAzul;
    private javax.swing.JSlider jSliderRayos;
    private javax.swing.JSlider jSliderRojo;
    private javax.swing.JSlider jSliderVerde;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JCheckBox jcbFading;
    private javax.swing.JLabel labelRayos;
    private javax.swing.JLabel lblDisplayFps;
    // End of variables declaration//GEN-END:variables

}
