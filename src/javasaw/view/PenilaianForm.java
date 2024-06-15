/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javasaw.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javasaw.dao.AlternatifDAO;
import javasaw.dao.AlternatifDAOMySQL;
import javasaw.dao.KriteriaDAO;
import javasaw.dao.KriteriaDAOMySQL;
import javasaw.model.Alternatif;
import javasaw.model.Kriteria;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author afgha
 */
public class PenilaianForm extends javax.swing.JFrame {
    
    private KriteriaDAO kriteriaDAO;
    private AlternatifDAO alternatifDAO;
    
    private Integer baris,kolom;
    private List<Kriteria> listKriteria = null;
    private List<Alternatif> listAlternatif = null;
    
    public PenilaianForm() {
        initComponents();
        kriteriaDAO = new KriteriaDAOMySQL();
        alternatifDAO = new AlternatifDAOMySQL();
        loadKriteriaRowAndColumn();
        
    }
    
    private void loadKriteriaRowAndColumn(){
        List<Kriteria> kriteria = kriteriaDAO.getAllKriteria();
        listKriteria = kriteria;
        kriteriaPanel.setLayout(new BoxLayout(kriteriaPanel,BoxLayout.X_AXIS));
        // Set a maximum size for the kriteriaPanel
        kriteriaPanel.setMaximumSize(new Dimension(737, 50)); // Adjust the size as needed
        kriteriaPanel.setPreferredSize(new Dimension(737, 50)); // Set preferred size for consistency

        // Clear the panel before adding new components
        kriteriaPanel.removeAll();
        
        listKriteria.forEach((e) -> {
            JLabel label = new JLabel();
            label.setText(e.getNamaKriteria());
            System.out.println(e.getNamaKriteria());

            // Set a preferred size for the label
            label.setPreferredSize(new Dimension(300, 50)); // Adjust dimensions as needed
            label.setMaximumSize(new Dimension(300, 50)); // Ensure the label does not exceed the preferred size
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT); // Center align the label

            // Add spacing around the label using EmptyBorder
            label.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adjust the padding as needed

            kriteriaPanel.add(label);
        });
        
        // Revalidate and repaint the panel to ensure it displays the new labels
        kriteriaPanel.revalidate();
        kriteriaPanel.repaint();
        
        List<Alternatif> alternatif = alternatifDAO.getAllAlternatif();
        listAlternatif = alternatif;
        
        alternatifPanel.setLayout(new BoxLayout(alternatifPanel, BoxLayout.Y_AXIS));
        alternatifPanel.setMaximumSize(new Dimension(70, 421));
        alternatifPanel.setPreferredSize(new Dimension(70, 421));

        // Clear the panel before adding new components
        alternatifPanel.removeAll();

        listAlternatif.forEach((a) -> {
            JLabel label = new JLabel();
            label.setText(a.getNamaAlternatif());
            System.out.println(a.getNamaAlternatif());

            // Set a preferred size for the label
            label.setPreferredSize(new Dimension(70, 50)); // Adjust dimensions as needed
            label.setMaximumSize(new Dimension(70, 50)); // Ensure the label does not exceed the preferred size
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT); // Center align the label

            // Add spacing around the label using EmptyBorder
            label.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adjust the padding as needed

            alternatifPanel.add(label);
        });

        // Revalidate and repaint the panel to ensure it displays the new labels
        alternatifPanel.revalidate();
        alternatifPanel.repaint();

        // Initialize and set up the formPanel for the matrix
        int rows = listAlternatif.size();
        int cols = listKriteria.size();
        formPanel.setLayout(new GridLayout(rows, cols));
        formPanel.setPreferredSize(new Dimension(743, 0));

        // Clear the panel before adding new components
        formPanel.removeAll();

        // Add JTextField components to the formPanel
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JTextField textField = new JTextField();
//                textField.setPreferredSize(new Dimension(30, 30)); // Smaller dimensions
                formPanel.add(textField);
            }
        }

        // Revalidate and repaint the panel to ensure it displays the new text fields
        formPanel.revalidate();
        formPanel.repaint();
        
    }
    
    
    @SuppressWarnings("unchecked")
    
    
        
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnKembali = new javax.swing.JButton();
        kriteriaPanel = new javax.swing.JPanel();
        formPanel = new javax.swing.JPanel();
        alternatifPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 51, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Penilaian");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        kriteriaPanel.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout kriteriaPanelLayout = new javax.swing.GroupLayout(kriteriaPanel);
        kriteriaPanel.setLayout(kriteriaPanelLayout);
        kriteriaPanelLayout.setHorizontalGroup(
            kriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        kriteriaPanelLayout.setVerticalGroup(
            kriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        formPanel.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        alternatifPanel.setBackground(new java.awt.Color(153, 153, 255));
        alternatifPanel.setForeground(new java.awt.Color(153, 102, 255));

        javax.swing.GroupLayout alternatifPanelLayout = new javax.swing.GroupLayout(alternatifPanel);
        alternatifPanel.setLayout(alternatifPanelLayout);
        alternatifPanelLayout.setHorizontalGroup(
            alternatifPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        alternatifPanelLayout.setVerticalGroup(
            alternatifPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alternatifPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kriteriaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnKembali))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKembali)
                .addGap(37, 37, 37)
                .addComponent(kriteriaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alternatifPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        DashboardForm df  = new DashboardForm();
        df.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(Alternatif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alternatif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alternatif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alternatif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenilaianForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alternatifPanel;
    private javax.swing.JButton btnKembali;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel kriteriaPanel;
    // End of variables declaration//GEN-END:variables
}
