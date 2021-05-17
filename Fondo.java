
package animaciones;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;


public class Fondo extends javax.swing.JFrame {


    public Fondo() {
        initComponents();
        setTitle("Animacion");
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inicio = new javax.swing.JButton();
        parar = new javax.swing.JButton();
        continuar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        velocidadAngular = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        inicio.setText("Inicio");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        parar.setText("Parar");
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });

        continuar.setText("Continuar");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        jLabel1.setText("Velocidad angular");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(velocidadAngular, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(inicio)
                        .addGap(108, 108, 108)
                        .addComponent(parar)
                        .addGap(114, 114, 114)
                        .addComponent(continuar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inicio)
                            .addComponent(parar)
                            .addComponent(continuar)))
                    .addComponent(velocidadAngular, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
      
         try{
            int velocidad=Integer.parseInt(this.velocidadAngular.getText());
            this.jPanel1.removeAll();
            lienzo=new Lienzo(this.jPanel1.getWidth()-4,this.jPanel1.getHeight()-4,velocidad);
            lienzo.setSize(this.jPanel1.getWidth()-4, this.jPanel1.getHeight()-4);
            lienzo.setLocation(2, 2);
            this.jPanel1.add(lienzo, BorderLayout.CENTER);
            this.repaint();

            this.lienzo.inicio();
         }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, "velocidad invalida", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_inicioActionPerformed

    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
          try{
        this.lienzo.parar();}
        catch(Exception e){
          JOptionPane.showMessageDialog(null, "Primero debe iniciar el ejercicio", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pararActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
          try{
        this.lienzo.continuar();}
        catch(Exception e){
          JOptionPane.showMessageDialog(null, "Primero debe iniciar el ejercicio", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_continuarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuar;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton parar;
    private javax.swing.JTextField velocidadAngular;
    // End of variables declaration//GEN-END:variables
    private Lienzo lienzo;
}
