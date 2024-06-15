package javasaw.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javasaw.database.DatabaseMySQL;
import javasaw.model.Alternatif;

public class AlternatifDAOMySQL implements AlternatifDAO {
    private static final String TABLE_NAME = "alternatif";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAMA_ALTERNATIF = "nama_alternatif";

    @Override
    public void insertAlternatif(Alternatif alternatif) {
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_NAMA_ALTERNATIF + ") VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, alternatif.getNamaAlternatif());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Alternatif> getAllAlternatifsWithKeyword(String keyword) {
        List<Alternatif> alternatifs = new ArrayList<>();

        try (Connection connection = DatabaseMySQL.connectDB();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM alternatif WHERE nama_alternatif LIKE ?")) {
            stmt.setString(1, "%" + keyword + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Alternatif a = new Alternatif();
                    a.setId(rs.getInt("id"));
                    a.setNamaAlternatif(rs.getString("nama_alternatif"));
                    alternatifs.add(a);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alternatifs;
    }

    @Override
    public void updateAlternatif(Alternatif alternatif) {
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAMA_ALTERNATIF + " = ? WHERE " + COLUMN_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, alternatif.getNamaAlternatif());
            preparedStatement.setInt(2, alternatif.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAlternatif(int id) {
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
    public List<Alternatif> getAllAlternatif() {
        List<Alternatif> alternatifList = new ArrayList<>();
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "SELECT * FROM " + TABLE_NAME;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Alternatif alternatif = new Alternatif();
                alternatif.setId(resultSet.getInt(COLUMN_ID));
                alternatif.setNamaAlternatif(resultSet.getString(COLUMN_NAMA_ALTERNATIF));
                alternatifList.add(alternatif);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alternatifList;
    }

    @Override
    public Alternatif getAlternatifById(int id) {
        Alternatif alternatif = null;
        try (Connection connection = DatabaseMySQL.connectDB()) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                alternatif = new Alternatif();
                alternatif.setId(resultSet.getInt(COLUMN_ID));
                alternatif.setNamaAlternatif(resultSet.getString(COLUMN_NAMA_ALTERNATIF));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alternatif;
    }

    @Override
    
    public Integer getCountAlternatif() {
      Integer count = 0;
      try (Connection connection = DatabaseMySQL.connectDB()) {
        String query = "SELECT COUNT(*) FROM " + TABLE_NAME; // Replace with your actual table name
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