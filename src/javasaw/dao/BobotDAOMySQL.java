/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javasaw.database.DatabaseMySQL;
import javasaw.model.Bobot;

/**
 *
 * @author afgha
 */public class BobotDAOMySQL implements BobotDAO {
    private static final String TABLE_NAME = "Bobot";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ID_KRITERIA = "id_kriteria";
    private static final String COLUMN_NILAI_BOBOT = "nilai_bobot";

    @Override
    public void insertBobot(Bobot bobot) {
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ID_KRITERIA + ", " + COLUMN_NILAI_BOBOT + ") VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bobot.getIdKriteria());
            preparedStatement.setDouble(2, bobot.getNilaiBobot());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBobot(Bobot bobot) {
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_ID_KRITERIA + " = ?, " + COLUMN_NILAI_BOBOT + " = ? WHERE " + COLUMN_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bobot.getIdKriteria());
            preparedStatement.setDouble(2, bobot.getNilaiBobot());
            preparedStatement.setInt(3, bobot.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBobot(int id) {
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
    public List<Bobot> getAllBobot() {
        List<Bobot> bobotList = new ArrayList<>();
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "SELECT * FROM " + TABLE_NAME;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Bobot bobot = new Bobot();
                bobot.setId(resultSet.getInt(COLUMN_ID));
                bobot.setIdKriteria(resultSet.getInt(COLUMN_ID_KRITERIA));
                bobot.setNilaiBobot(resultSet.getDouble(COLUMN_NILAI_BOBOT));
                bobotList.add(bobot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bobotList;
    }

    @Override
    public Bobot getBobotById(int id) {
        Bobot bobot = null;
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bobot = new Bobot();
                bobot.setId(resultSet.getInt(COLUMN_ID));
                bobot.setIdKriteria(resultSet.getInt(COLUMN_ID_KRITERIA));
                bobot.setNilaiBobot(resultSet.getDouble(COLUMN_NILAI_BOBOT));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bobot;
    }
}
