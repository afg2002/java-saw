/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javasaw.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javasaw.dao.AlternatifDAO;
import javasaw.dao.AlternatifDAOMySQL;
import javasaw.dao.KriteriaDAO;
import javasaw.dao.KriteriaDAOMySQL;
import javasaw.dao.NormalisasiDAO;
import javasaw.dao.NormalisasiDAOMySQL;
import javasaw.dao.RankingDAO;
import javasaw.dao.RankingDAOMySQL;
import javasaw.model.Alternatif;
import javasaw.model.Kriteria;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
    private JTextField[][] textFields;
    
    
    
    public PenilaianForm() {
        initComponents();
        kriteriaDAO = new KriteriaDAOMySQL();
        alternatifDAO = new AlternatifDAOMySQL();
        loadKriteriaRowAndColumn();
        
        
    }
    
    private void loadKriteriaRowAndColumn(){
        List<Kriteria> kriteria = kriteriaDAO.getAllKriteria();
        listKriteria = kriteria;
        kriteriaPanel.setLayout(new GridLayout(1, listKriteria.size()));
        // Set a maximum size for the kriteriaPanel
        kriteriaPanel.setMaximumSize(new Dimension(737, 50)); // Adjust the size as needed
        kriteriaPanel.setPreferredSize(new Dimension(737, 50)); // Set preferred size for consistency

        
        listKriteria.forEach((e) -> {
            JLabel label = new JLabel();
            label.setText(e.getNamaKriteria() + " (" + e.getTipeKriteria()  + ")");
            label.setName(String.valueOf(e.getId())+"_" + e.getTipeKriteria());
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT); // Center align the label
            label.setBorder(new EmptyBorder(70, 70, 70, 70));

            kriteriaPanel.add(label);
        });
        
        // Revalidate and repaint the panel to ensure it displays the new labels
        kriteriaPanel.revalidate();
        kriteriaPanel.repaint();
        
        List<Alternatif> alternatif = alternatifDAO.getAllAlternatif();
        listAlternatif = alternatif;
        
        alternatifPanel.setLayout(new BoxLayout(alternatifPanel, BoxLayout.Y_AXIS));
        
        // Clear the panel before adding new components
        alternatifPanel.removeAll();

        listAlternatif.forEach((a) -> {
            JLabel label = new JLabel();
            label.setText(a.getNamaAlternatif());

            // Set a preferred size for the label
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT); // Center align the label
            label.setBorder(new EmptyBorder(40, 10, 40, 10)); // Adjust the padding as needed

            alternatifPanel.add(label);
        });

        // Revalidate and repaint the panel to ensure it displays the new labels
        alternatifPanel.revalidate();
        alternatifPanel.repaint();
        // Set up the formPanel with GridLayout
        formPanel.setLayout(new GridLayout(listAlternatif.size(), listKriteria.size(), 5, 5));
        textFields = new JTextField[listAlternatif.size()][listKriteria.size()];
         for (int i = 0; i < listAlternatif.size(); i++) {
            for (int j = 0; j < listKriteria.size(); j++) {
                JTextField textField = new JTextField();
                textField.setName("textfield_" + i + "_" + j); // Set name of the text field
                textField.setPreferredSize(new Dimension(100, 30)); // Set preferred size for text fields
                formPanel.add(textField);
                textFields[i][j] = textField; // Store in the matrix
            }
        }

        formPanel.revalidate();
        formPanel.repaint();
        

    }
    
    
    @SuppressWarnings("unchecked")
    
    
        
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        kriteriaPanel = new javax.swing.JPanel();
        formPanel = new javax.swing.JPanel();
        alternatifPanel = new javax.swing.JPanel();
        btnHitung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 900));

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        kriteriaPanelLayout.setVerticalGroup(
            kriteriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        formPanel.setBackground(new java.awt.Color(153, 153, 255));
        formPanel.setToolTipText("");
        formPanel.setPreferredSize(new java.awt.Dimension(400, 0));

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnKembali))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alternatifPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kriteriaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE))))
                .addGap(43, 43, 43))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(382, Short.MAX_VALUE)
                .addComponent(btnHitung)
                .addGap(351, 351, 351))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnKembali)
                .addGap(43, 43, 43)
                .addComponent(kriteriaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alternatifPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(btnHitung)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        DashboardForm df  = new DashboardForm();
        df.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        calculateSAW();
    }//GEN-LAST:event_btnHitungActionPerformed
    
    private void calculateSAW() {
    double[][] values = new double[listAlternatif.size()][listKriteria.size()];

    // Collect values from the text fields
    for (int i = 0; i < listAlternatif.size(); i++) {
        for (int j = 0; j < listKriteria.size(); j++) {
            try {
                values[i][j] = Double.parseDouble(textFields[i][j].getText());
            } catch (NumberFormatException e) {
                values[i][j] = 0;
            }
        }
    }

    // Normalize the values based on the type of criteria
    double[][] normalizedValues = new double[listAlternatif.size()][listKriteria.size()];
    for (int j = 0; j < listKriteria.size(); j++) {
        double[] column = new double[listAlternatif.size()];
        for (int i = 0; i < listAlternatif.size(); i++) {
            column[i] = values[i][j];
        }
        double max = getMax(column);
        double min = getMin(column);

        for (int i = 0; i < listAlternatif.size(); i++) {
            if (listKriteria.get(j).getTipeKriteria().equalsIgnoreCase("benefit")) {
                normalizedValues[i][j] = values[i][j] / max;
            } else {
                normalizedValues[i][j] = min / values[i][j];
            }
        }
    }

    // Calculate the final scores for each alternative
    double[] finalScores = new double[listAlternatif.size()];
    for (int i = 0; i < listAlternatif.size(); i++) {
        double score = 0;
        for (int j = 0; j < listKriteria.size(); j++) {
            double weight = listKriteria.get(j).getBobotKriteria() / 100.0; // Convert percentage to decimal
            score += normalizedValues[i][j] * weight; // Apply the weight
        }
        finalScores[i] = score;
    }

    // Insert normalized values and final scores into the database
    NormalisasiDAO normalisasiDAO = new NormalisasiDAOMySQL();
    RankingDAO rankingDAO = new RankingDAOMySQL();

    normalisasiDAO.deleteAllNormalizedValues();
    rankingDAO.deleteAllFinalScores();
    for (int i = 0; i < listAlternatif.size(); i++) {
        for (int j = 0; j < listKriteria.size(); j++) {
            normalisasiDAO.insertNormalizedValue(listAlternatif.get(i).getId(), listKriteria.get(j).getId(), normalizedValues[i][j]);
        }
        rankingDAO.insertFinalScore(listAlternatif.get(i).getId(), finalScores[i]);
    }

    // Open the NormalisasiMatriks form to display the results
    NormalisasiMatriks normalisasiMatriks = new NormalisasiMatriks(normalizedValues, finalScores, listKriteria, listAlternatif);
    normalisasiMatriks.setVisible(true);
}


    private double getMax(double[] array) {
        double max = array[0];
        for (double v : array) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    private double getMin(double[] array) {
        double min = array[0];
        for (double v : array) {
            if (v < min) {
                min = v;
            }
        }
        return min;
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
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKembali;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel kriteriaPanel;
    // End of variables declaration//GEN-END:variables
}
