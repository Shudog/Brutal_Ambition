/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.diceRollerGUI;

import javax.swing.JFrame;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

/**
 *
 * @author Matt
 */
public class PlayerWindow extends javax.swing.JFrame {

    /**
     * Creates new form PlayerWindow
     */
    public PlayerWindow() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        playerListArea = new javax.swing.JList<>();
        playerListCancelButton = new javax.swing.JButton();
        playerListNewButton = new javax.swing.JButton();
        playerListOkButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playerListArea.setSelectionMode(SINGLE_SELECTION);
        playerListArea.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(playerListArea);

        playerListCancelButton.setText("Cancel");
        playerListCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerListCancelButtonActionPerformed(evt);
            }
        });

        playerListNewButton.setText("New");
        playerListNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerListNewButtonActionPerformed(evt);
            }
        });

        playerListOkButton.setText("OK");
        playerListOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerListOkButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerListCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerListNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerListOkButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(playerListOkButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(playerListNewButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerListCancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playerListNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerListNewButtonActionPerformed

        JFrame NewPlayerWindow;
        NewPlayerWindow = new NewPlayerWindow();
        NewPlayerWindow.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_playerListNewButtonActionPerformed

    private void playerListCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerListCancelButtonActionPerformed
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_playerListCancelButtonActionPerformed

    private void playerListOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerListOkButtonActionPerformed
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_playerListOkButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> playerListArea;
    private javax.swing.JButton playerListCancelButton;
    private javax.swing.JButton playerListNewButton;
    private javax.swing.JButton playerListOkButton;
    // End of variables declaration//GEN-END:variables
}