
package javasaw.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.*;
import lombok.NoArgsConstructor;
import javasaw.database.DatabaseMySQL;

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
}
