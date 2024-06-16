/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.dao;

import javasaw.database.DatabaseMySQL;
import java.sql.*;

public class NormalisasiDAOMySQL implements NormalisasiDAO{
    private Connection connection;

    public NormalisasiDAOMySQL() {
        // Initialize the connection
        this.connection = DatabaseMySQL.connectDB();
    }

    public void insertNormalizedValue(int alternatifId, int kriteriaId, double normalizedValue) {
        String query = "INSERT INTO normalisasi (alternatif_id, kriteria_id, nilai_normalisasi) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, alternatifId);
            preparedStatement.setInt(2, kriteriaId);
            preparedStatement.setDouble(3, normalizedValue);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllNormalizedValues() {
        String query = "DELETE FROM normalisasi";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
