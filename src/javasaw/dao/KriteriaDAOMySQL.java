/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasaw.dao;

import javasaw.database.DatabaseMySQL;
import javasaw.model.Kriteria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afgha
 */
public class KriteriaDAOMySQL implements KriteriaDAO {
    private static final String TABLE_NAME = "kriteria";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAMA_KRITERIA = "nama_kriteria";
    private static final String COLUMN_NAMA_TIPE_KRITERIA = "tipe_kriteria";
    private static final String COLUMN_BOBOT_KRITERIA = "bobot_kriteria";
    
    public List<Kriteria> getAllKriteriasWithKeyword(String keyword) {
    List<Kriteria> kriterias = new ArrayList<>();

    try (Connection connection = DatabaseMySQL.connectDB();
         PreparedStatement stmt = connection.prepareStatement("SELECT * FROM kriteria WHERE nama_kriteria LIKE ?")) {
        stmt.setString(1, "%" + keyword + "%");
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Kriteria k = new Kriteria();
                k.setId(rs.getInt("id"));
                k.setNamaKriteria(rs.getString("nama_kriteria"));
                k.setTipeKriteria(rs.getString("tipe_kriteria"));
                k.setBobotKriteria(rs.getInt("bobot_kriteria"));
                kriterias.add(k);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return kriterias;
}

    @Override
    public void insertKriteria(Kriteria kriteria) {
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_NAMA_KRITERIA + ", " + COLUMN_NAMA_TIPE_KRITERIA + ", " + COLUMN_BOBOT_KRITERIA + ") VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, kriteria.getNamaKriteria());
            preparedStatement.setString(2, kriteria.getTipeKriteria());
            preparedStatement.setInt(3, kriteria.getBobotKriteria());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void updateKriteria(Kriteria kriteria) {
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAMA_KRITERIA + "  = ?, " + COLUMN_NAMA_TIPE_KRITERIA + "  = ? , " + COLUMN_BOBOT_KRITERIA + "  = ?  WHERE " + COLUMN_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, kriteria.getNamaKriteria());
            preparedStatement.setString(2, kriteria.getTipeKriteria());
            preparedStatement.setInt(3, kriteria.getBobotKriteria());
            preparedStatement.setInt(4, kriteria.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteKriteria(int id) {
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
    public List<Kriteria> getAllKriteria() {
        List<Kriteria> kriteriaList = new ArrayList<>();
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "SELECT * FROM " + TABLE_NAME;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Kriteria kriteria = new Kriteria();
                kriteria.setId(resultSet.getInt(COLUMN_ID));
                kriteria.setNamaKriteria(resultSet.getString(COLUMN_NAMA_KRITERIA));
                kriteria.setTipeKriteria(resultSet.getString(COLUMN_NAMA_TIPE_KRITERIA));
                kriteria.setBobotKriteria(resultSet.getInt(COLUMN_BOBOT_KRITERIA));
                kriteriaList.add(kriteria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kriteriaList;
    }

    @Override
    public Kriteria getKriteriaById(int id) {
        Kriteria kriteria = null;
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                kriteria = new Kriteria();
                kriteria.setId(resultSet.getInt(COLUMN_ID));
                kriteria.setNamaKriteria(resultSet.getString(COLUMN_NAMA_KRITERIA));
                kriteria.setTipeKriteria(resultSet.getString(COLUMN_NAMA_TIPE_KRITERIA));
                kriteria.setBobotKriteria(resultSet.getInt(COLUMN_BOBOT_KRITERIA));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kriteria;
    }

    @Override
    public Integer getCountKriteria() {
      Integer count = 0;
      try (Connection connection = DatabaseMySQL.connectDB()) {
        String query = "SELECT COUNT(*) FROM " + TABLE_NAME;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
          count = resultSet.getInt(1);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return count;
    }

}
