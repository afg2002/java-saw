
package javasaw.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;
import javasaw.database.DatabaseMySQL;
import javasaw.model.Ranking;

public class RankingDAOMySQL implements RankingDAO{
     private Connection connection;

    public RankingDAOMySQL() {
        // Initialize the connection
        this.connection = DatabaseMySQL.connectDB();
    }

    public void insertFinalScore(int alternatifId, double finalScore) {
        String query = "INSERT INTO ranking (alternatif_id, skor_akhir) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, alternatifId);
            preparedStatement.setDouble(2, finalScore);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public void deleteAllFinalScores() {
        String query = "DELETE FROM ranking";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ranking> getRankingFinalScore() {
        String query = "SELECT r.id, r.alternatif_id, r.skor_akhir, a.nama_alternatif, " +
                       "RANK() OVER (ORDER BY r.skor_akhir DESC) AS ranking " +
                       "FROM ranking r " +
                       "JOIN alternatif a ON r.alternatif_id = a.id";
        List<Ranking> rankings = new ArrayList<>();
        
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query);
            
             ResultSet resultSet = preparedStatement.executeQuery()) {
             
            while (resultSet.next()) {
                Ranking ranking = new Ranking();
                ranking.setId(resultSet.getInt("id"));
                ranking.setAlternatif_id(resultSet.getInt("alternatif_id"));
                ranking.setSkor_akhir(resultSet.getDouble("skor_akhir"));
                ranking.setNama_alternatif(resultSet.getString("nama_alternatif"));
                ranking.setRanking(resultSet.getInt("ranking"));
                rankings.add(ranking);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rankings;
    }

}
