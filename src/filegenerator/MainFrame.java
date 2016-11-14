/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filegenerator;

import compressors.Huffman.Huffman;
import compressors.LZW;
import compressors.RLE;
import helpers.RandomGenerator;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author Fzwael
 */
public class MainFrame extends javax.swing.JFrame {
    
    private boolean alg1 , alg2 , alg3 , alg4;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        // initialize all algorithms to false ( not choson )
        alg1 = alg2 = alg3 = alg4 = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nbLingnetxt = new javax.swing.JTextField();
        sizeInput = new javax.swing.JTextField();
        nomFichiertxt = new javax.swing.JTextField();
        nameInput = new javax.swing.JTextField();
        validatebtn = new javax.swing.JButton();
        sizeUnitInput = new javax.swing.JComboBox<>();
        checkbtn1 = new javax.swing.JCheckBox();
        checkbtn2 = new javax.swing.JCheckBox();
        checkbtn3 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nbLingnetxt.setEditable(false);
        nbLingnetxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nbLingnetxt.setText("        Donnez la taille du fichier");
        nbLingnetxt.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        nbLingnetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbLingnetxtActionPerformed(evt);
            }
        });

        nomFichiertxt.setEditable(false);
        nomFichiertxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nomFichiertxt.setText("         Donnez le nom du fichier");
        nomFichiertxt.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        nomFichiertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomFichiertxtActionPerformed(evt);
            }
        });

        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });

        validatebtn.setText("Validate");
        validatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validatebtnActionPerformed(evt);
            }
        });

        sizeUnitInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KO", "MO", "GO" }));
        sizeUnitInput.setToolTipText("");

        checkbtn1.setText("RLE ");
        checkbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbtn1ActionPerformed(evt);
            }
        });

        checkbtn2.setText("HUFFMAN");
        checkbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbtn2ActionPerformed(evt);
            }
        });

        checkbtn3.setText("LZW");
        checkbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(sizeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(sizeUnitInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(validatebtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkbtn1)
                                .addGap(59, 59, 59)
                                .addComponent(checkbtn2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkbtn3))
                            .addComponent(nomFichiertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nbLingnetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(nbLingnetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeUnitInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nomFichiertxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkbtn1)
                    .addComponent(checkbtn2)
                    .addComponent(checkbtn3))
                .addGap(28, 28, 28)
                .addComponent(validatebtn)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nbLingnetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbLingnetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbLingnetxtActionPerformed

    private void nomFichiertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomFichiertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomFichiertxtActionPerformed

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

    private void validatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validatebtnActionPerformed
        int unit =  1024;
        if (sizeUnitInput.getSelectedItem().toString().equals("MO"))
            unit =  1024 * 1024;
        if (sizeUnitInput.getSelectedItem().toString().equals("GO"))
            unit =  1024 * 1024 * 1024;
        int size = Integer.parseInt(sizeInput.getText()) * unit;
        int nbChar = size ; // 1 byte per char 
        //int lineLength = 1000; // TODO make user choose is
        //int nbLines = nbChar / (lineLength + 1); // retour a la ligne = 2
        //int lastLinechars = nbChar - nbLines * (lineLength + 1);
        try{
            File file = new File(nameInput.getText());
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            /*
            for(int i=0 ; i< size / 1000 ; i++){
                writer.print(RandomGenerator.generateRandomString(1000));
            }
            writer.print(RandomGenerator.generateRandomString(size - ((size/1000) * 1000)));
            */
            
             //LRE efficace
            for(int x=0 ; x < 100 ; x++)
                writer.print("AAAAAAAAAAAAAAAAAAAACCCCCCCCCCCCCCCCCCCAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
            
            /*
             //LZW efficace
            for(int x=0 ; x < 100 ; x++)
                writer.print("ABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCABBAAABAABCAABCAABCABCAB");
            */
            writer.close();
            System.out.println("calculated size is " + size);
            System.out.println("actual size is " + file.length());
            System.out.println("NOW COMPRESSING FILE");
                if(alg1){
                    System.out.println("RLE");
                        RLE.compress(file);
                }
                if(alg2){
                    System.out.println("HUFFMAN");
                    Huffman.compress(file);
                }
                if(alg3){
                    System.out.println("LZW");
                    LZW.compress(file);
                }
                if(alg4){
                    System.out.println("ALGORITHME 4");
                    
                }
                
            }
        catch (Exception e) {
                // do something
            }
    }//GEN-LAST:event_validatebtnActionPerformed

    private void checkbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbtn1ActionPerformed
        // TODO add your handling code here:
        System.out.println("ALG1");
        alg1 = !alg1;
    }//GEN-LAST:event_checkbtn1ActionPerformed

    private void checkbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbtn2ActionPerformed
        // TODO add your handling code here:
        System.out.println("ALG2");
        alg2 = !alg2;
    }//GEN-LAST:event_checkbtn2ActionPerformed

    private void checkbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbtn3ActionPerformed
        // TODO add your handling code here:
        System.out.println("ALG3");
        alg3 = !alg3;
    }//GEN-LAST:event_checkbtn3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkbtn1;
    private javax.swing.JCheckBox checkbtn2;
    private javax.swing.JCheckBox checkbtn3;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField nbLingnetxt;
    private javax.swing.JTextField nomFichiertxt;
    private javax.swing.JTextField sizeInput;
    private javax.swing.JComboBox<String> sizeUnitInput;
    private javax.swing.JButton validatebtn;
    // End of variables declaration//GEN-END:variables
}
