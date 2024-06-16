package javasaw.view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import javasaw.model.Alternatif;
import javasaw.model.Kriteria;
import javax.swing.border.EmptyBorder;

public class NormalisasiMatriks extends JFrame {

    private JPanel formPanel = new JPanel();

    public NormalisasiMatriks(double[][] normalizedValues, double[] finalScores, List<Kriteria> kriteriaList, List<Alternatif> alternatifList) {
      
        setTitle("Normalized Matrix and Final Scores");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        formPanel.setLayout(new GridLayout(alternatifList.size() + 1, kriteriaList.size() + 3)); // +3 for final score and rank columns

        // Calculate ranks based on final scores
        Integer[] ranks = calculateRanks(finalScores);

        // Add headers for columns
        JLabel headerLabel = new JLabel("Alternatif/Kriteria", JLabel.CENTER);
        styleHeaderLabel(headerLabel);
        formPanel.add(headerLabel);

        for (Kriteria kriteria : kriteriaList) {
            JLabel kriteriaLabel = new JLabel(kriteria.getNamaKriteria() + " (" + kriteria.getTipeKriteria() + ")", JLabel.CENTER);
            styleHeaderLabel(kriteriaLabel);
            formPanel.add(kriteriaLabel);
        }

        JLabel finalScoreHeaderLabel = new JLabel("Final Score", JLabel.CENTER);
        styleHeaderLabel(finalScoreHeaderLabel);
        formPanel.add(finalScoreHeaderLabel);

        JLabel rankHeaderLabel = new JLabel("Rank", JLabel.CENTER);
        styleHeaderLabel(rankHeaderLabel);
        formPanel.add(rankHeaderLabel);

        // Add normalized values, final scores, and ranks
        for (int i = 0; i < alternatifList.size(); i++) {
            JLabel alternatifLabel = new JLabel(alternatifList.get(i).getNamaAlternatif(), JLabel.CENTER);
            styleAlternatifLabel(alternatifLabel);
            formPanel.add(alternatifLabel);

            for (int j = 0; j < kriteriaList.size(); j++) {
                JLabel valueLabel = new JLabel(String.format("%.4f", normalizedValues[i][j]), JLabel.CENTER);
                styleValueLabel(valueLabel);
                formPanel.add(valueLabel);
            }

            JLabel scoreLabel = new JLabel(String.format("%.4f", finalScores[i]), JLabel.CENTER);
            styleScoreLabel(scoreLabel);
            formPanel.add(scoreLabel);

            JLabel rankLabel = new JLabel(ranks[i].toString(), JLabel.CENTER);
            styleRankLabel(rankLabel);
            formPanel.add(rankLabel);
        }

        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Center align the frame on screen
        setLocationRelativeTo(null);
    }

    private void styleHeaderLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setOpaque(true);
        label.setBackground(new Color(70, 130, 180));
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setPreferredSize(new Dimension(150, 40));
    }

    private void styleAlternatifLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setOpaque(true);
        label.setBackground(new Color(245, 245, 245));
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setPreferredSize(new Dimension(150, 30));
    }

    private void styleValueLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setOpaque(true);
        label.setBackground(new Color(255, 255, 255));
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setPreferredSize(new Dimension(100, 30));
    }

    private void styleScoreLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setOpaque(true);
        label.setBackground(new Color(220, 220, 220));
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setPreferredSize(new Dimension(100, 30));
    }

    private void styleRankLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setOpaque(true);
        label.setBackground(new Color(173, 216, 230));
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setPreferredSize(new Dimension(100, 30));
    }

    private Integer[] calculateRanks(double[] finalScores) {
        Integer[] indices = IntStream.range(0, finalScores.length).boxed().toArray(Integer[]::new);
        Arrays.sort(indices, (i, j) -> Double.compare(finalScores[j], finalScores[i]));

        Integer[] ranks = new Integer[finalScores.length];
        for (int i = 0; i < indices.length; i++) {
            ranks[indices[i]] = i + 1;
        }

        return ranks;
    }
}
