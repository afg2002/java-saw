/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javasaw.database.DatabaseMySQL;
import javasaw.model.Penilaian;

public class PenilaianDAOMySQL implements PenilaianDAO {
    private static final String TABLE_NAME = "Penilaian";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ID_ALTERNATIF = "id_alternatif";
    private static final String COLUMN_ID_KRITERIA = "id_kriteria";
    private static final String COLUMN_NILAI = "nilai";

    @Override
    public void insertPenilaian(Penilaian penilaian) {
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID_ALTERNATIF + ", " + COLUMN_ID_KRITERIA + ", " + COLUMN_NILAI + ") VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, penilaian.getIdAlternatif());
            preparedStatement.setInt(2, penilaian.getIdKriteria());
            preparedStatement.setDouble(3, penilaian.getNilai());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePenilaian(Penilaian penilaian) {
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_ID_ALTERNATIF + " = ?, " + COLUMN_ID_KRITERIA + " = ?, " + COLUMN_NILAI + " = ? WHERE " + COLUMN_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, penilaian.getIdAlternatif());
            preparedStatement.setInt(2, penilaian.getIdKriteria());
            preparedStatement.setDouble(3, penilaian.getNilai());
            preparedStatement.setInt(4, penilaian.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePenilaian(int id) {
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Penilaian> getAllPenilaian() {
        List<Penilaian> penilaianList = new ArrayList<>();
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "SELECT * FROM " + TABLE_NAME;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Penilaian penilaian = new Penilaian();
                penilaian.setId(resultSet.getInt(COLUMN_ID));
                penilaian.setIdAlternatif(resultSet.getInt(COLUMN_ID_ALTERNATIF));
                penilaian.setIdKriteria(resultSet.getInt(COLUMN_ID_KRITERIA));
                penilaian.setNilai(resultSet.getDouble(COLUMN_NILAI));
                penilaianList.add(penilaian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penilaianList;
    }

    @Override
    public Penilaian getPenilaianById(int id) {
        Penilaian penilaian = null;
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                penilaian = new Penilaian();
                penilaian.setId(resultSet.getInt(COLUMN_ID));
                penilaian.setIdAlternatif(resultSet.getInt(COLUMN_ID_ALTERNATIF));
                penilaian.setIdKriteria(resultSet.getInt(COLUMN_ID_KRITERIA));
                penilaian.setNilai(resultSet.getDouble(COLUMN_NILAI));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penilaian;
    }
}

