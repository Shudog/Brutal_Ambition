/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.diceRollerGUI;

/**
 *
 * @author Matt
 */
public class NewPlayerWindow extends javax.swing.JFrame {

    /**
     * Creates new form NewPlayerWindow
     */
    public NewPlayerWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        newPlayerNameField = new javax.swing.JTextField();
        newPlayerNameLabel = new javax.swing.JLabel();
        newPlayerCancelButton = new javax.swing.JButton();
        newPlayerOkButton = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newPlayerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlayerNameFieldActionPerformed(evt);
            }
        });

        newPlayerNameLabel.setText("Name: ");

        newPlayerCancelButton.setText("Cancel");
        newPlayerCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlayerCancelButtonActionPerformed(evt);
            }
        });

        newPlayerOkButton.setText("OK");
        newPlayerOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlayerOkButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(newPlayerCancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(newPlayerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 197, Short.MAX_VALUE)
                        .addComponent(newPlayerOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(newPlayerNameField))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newPlayerNameField)
                    .addComponent(newPlayerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPlayerCancelButton)
                    .addComponent(newPlayerOkButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newPlayerCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPlayerCancelButtonActionPerformed
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_newPlayerCancelButtonActionPerformed

    private void newPlayerOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPlayerOkButtonActionPerformed
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_newPlayerOkButtonActionPerformed

    private void newPlayerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPlayerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPlayerNameFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton newPlayerCancelButton;
    private javax.swing.JTextField newPlayerNameField;
    private javax.swing.JLabel newPlayerNameLabel;
    private javax.swing.JButton newPlayerOkButton;
    // End of variables declaration//GEN-END:variables
}